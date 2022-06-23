package agaig.justeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

    @GetMapping("")
    public String signIn() {
        return "/member/signIn";
    }

    @GetMapping("/kakao")
    public String sns() {
        return "/member/sns";
    }
}
