package agaig.justeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/stf")
public class SelfTestFoundationController {

    @GetMapping("")
    public String SelfTestFoundation() {return "/selftest/SelfTestFoundation";}

    @PostMapping("/st") //PostMapping 인식 안됨
    public String SelfTest() {return "/selftest/SelfTest";}
}
