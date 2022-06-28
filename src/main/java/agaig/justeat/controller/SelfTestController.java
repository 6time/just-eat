package agaig.justeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/st")
public class SelfTestController {

    @PostMapping("")
    public String SelfTest() {return "/selftest/SelfTest";}

}
