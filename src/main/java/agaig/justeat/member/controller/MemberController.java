package agaig.justeat.member.controller;

import agaig.justeat.member.annotation.MemberSignInCheck;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import agaig.justeat.member.dto.MemberSaveRequestDto;
import agaig.justeat.member.dto.MemberUpdateRequestDto;
import agaig.justeat.member.exception.SignInException;
import agaig.justeat.member.service.MemberService;
import agaig.justeat.member.util.MemberSha256;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public String getSignIn(HttpSession session) {
        Object sessionAttribute = session.getAttribute("session");
        if (sessionAttribute == null) {
            return "/member/signIn";
        }
        return "redirect:/";
    }

    @PostMapping("")
    public String postSignIn(String email, String password, boolean rememberId, String toURL, HttpServletRequest request, HttpServletResponse response) {

        Long member_id = memberService.signIn(email, password);

        Cookie idCookie = new Cookie("email", email);
        if (!rememberId) {
            idCookie.setMaxAge(0);
        }
        response.addCookie(idCookie);

        HttpSession session = request.getSession();
        session.setAttribute("session", member_id);

        toURL = toURL == null || toURL.equals("") ? "/" : toURL;
        return "redirect:" + toURL;
    }

    @GetMapping("signUp")
    public String getSignUp() {
        return "/member/signUp";
    }

    @PostMapping("signUp")
    public String postSignUp(String nickname, MemberSaveRequestDto requestDto) {
        requestDto.setName(nickname);
        memberService.join(requestDto);
        return "/member/signIn";
    }

    @GetMapping("/kakao")
    public String sns(@RequestParam(value = "code", required = false) String code, HttpSession session) {
        String access_Token = memberService.getAccessToken(code);
        HashMap<String, Object> userInfo = memberService.getUserInfo(access_Token);
        String encryptPassword = null;
        try {
            encryptPassword = MemberSha256.encrypt(String.valueOf(userInfo.get("id")));
            session.setAttribute("session", memberService.signIn((String) userInfo.get("email"), encryptPassword));
            return "redirect:/";
        } catch (SignInException e) {
            MemberSaveRequestDto memberSaveRequestDto = new MemberSaveRequestDto();
            memberSaveRequestDto.setEmail((String) userInfo.get("email"));
            memberSaveRequestDto.setName((String) userInfo.get("nickname"));
            memberSaveRequestDto.setPassword(encryptPassword);
            memberSaveRequestDto.setGender((String) userInfo.get("gender"));
            memberService.join(memberSaveRequestDto);
            session.setAttribute("session", memberService.signIn((String) userInfo.get("email"), encryptPassword));
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @MemberSignInCheck
    @GetMapping("/info/{id}")
    public String memberInfo(@PathVariable Long id, Model model, HttpSession session) {
        memberService.verify(id, session);
        MemberUpdateResponseDto responseDto = memberService.findInfoById(id);
        model.addAttribute("updateMember", responseDto);
        return "/member/memberUpdate";
    }

    @MemberSignInCheck
    @PostMapping("/info/{id}")
    public String update(@PathVariable Long id, String password, MemberUpdateRequestDto requestDto, Model model) {
        try {
            memberService.passwordCheck(id, password);
        } catch (SignInException e) {
            System.out.println("접근 권한이 필요합니다.");
            return "redirect:/members/info/" + id + "?error=1";
        }
        memberService.update(id, requestDto);
        MemberUpdateResponseDto responseDto = memberService.findInfoById(id);
        model.addAttribute("updateMember", responseDto);
        return "/member/memberUpdate";
    }
}
