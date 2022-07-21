package agaig.justeat.selftest.controller;

import agaig.justeat.selftest.domain.SelfTest;
import agaig.justeat.selftest.dto.SelfTestSaveRequestDto;
import agaig.justeat.selftest.service.SelfTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class SelfTestController { //controller 프레젠테이션 계층으로 클라이언트의 요청을 처리


    public final SelfTestService selfTestService;
    @Autowired
    public SelfTestController(SelfTestService selfTestService) {
        this.selfTestService = selfTestService;
    }

    @PostMapping("selftest")
    public String SelfTest(SelfTestSaveRequestDto requestDto, double daykcal, double dayweight, int dayexercise) {
        selfTestService.save(requestDto.toEntity());
        return "/selftest/SelfTest";
    }

    @GetMapping("selftest")
    public String SelfTestFoundation() {
        return "/selftest/SelfTestFoundation";
    }

    @GetMapping("list")
    public String list(Model model) {
        List<SelfTest> selfTests = selfTestService.findMembers();
        model.addAttribute("selftest", selfTests); //model에 담기
        return "selftest/SelfTestList";
    }

}


