package agaig.justeat.controller;

import agaig.justeat.dto.MemberResponseDto;
import agaig.justeat.dto.MemberSaveRequestDto;
import agaig.justeat.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public String getSignIn() {
        return "/member/signIn";
    }

    @PostMapping("")
    public String postSignIn(String email, String password, boolean rememberId, String toURL, HttpServletRequest request, HttpServletResponse response) {
        MemberResponseDto responseDto = memberService.signIn(email, password);
        Cookie cookie = new Cookie("email", email);
        if (!rememberId) {
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
        HttpSession session = request.getSession();
        session.setAttribute("session", responseDto);
        toURL = toURL == null || toURL.equals("") ? "/" : toURL;
        return "redirect:" + toURL;
    }

    @GetMapping("signUp")
    public String getSignUp() {
        return "/member/signUp";
    }

    @PostMapping("signUp")
    public String postSignUp(MemberSaveRequestDto requestDto) {
        memberService.join(requestDto);
        return "/member/signIn";
    }


    @GetMapping("/kakao")
    public String sns() {
        return "/member/sns";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
