package agaig.justeat.controller;

import agaig.justeat.domain.Member;
import agaig.justeat.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private final MemberService memberService;

    public MainController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public String main(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "index";
    }

    @GetMapping("/self")
    public String self(HttpSession session) {
        try {
            memberService.signInCheck(session);
            return "/selftest/SelfTestFoundation";
        } catch (Exception e) {
            return "/member/signIn";
        }
    }
}
