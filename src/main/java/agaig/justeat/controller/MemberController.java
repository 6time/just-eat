package agaig.justeat.controller;

import agaig.justeat.domain.Member;
import agaig.justeat.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public String signIn() {
        Member member = new Member();
        member.setEmail("pg@gmail.com");
        Long join = memberService.join(member);
        System.out.println(join);
        return "/member/signIn";
    }

    @GetMapping("/kakao")
    public String sns() {
        return "/member/sns";
    }
}
