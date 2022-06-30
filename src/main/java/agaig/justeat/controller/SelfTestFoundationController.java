package agaig.justeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/stf")
public class SelfTestFoundationController {

    @GetMapping("")
    public String SelfTestFoundation() {return "/selftest/SelfTestFoundation";}

}
