package agaig.justeat.controller;

import agaig.justeat.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String main(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "index";
    }
}
