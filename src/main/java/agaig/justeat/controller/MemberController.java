package agaig.justeat.controller;

import agaig.justeat.dto.MemberResponseDto;
import agaig.justeat.dto.MemberSaveRequestDto;
import agaig.justeat.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String postSignIn(String email, String password, HttpSession session) {
        System.out.println(email);
        MemberResponseDto responseDto = memberService.signIn(email, password);
        session.setAttribute("session", responseDto);
        return "/index";
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
}
