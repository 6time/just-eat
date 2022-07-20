package agaig.justeat.selftest.controller;

import agaig.justeat.selftest.dto.SelfTestSaveRequestDto;
import agaig.justeat.selftest.service.SelfTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/selftest")
public class SelfTestController { //controller 프레젠테이션 계층으로 클라이언트의 요청을 처리


    public final SelfTestService selfTestService;
    @Autowired
    public SelfTestController(SelfTestService selfTestService) {
        this.selfTestService = selfTestService;
    }

    @PostMapping("")
    public String SelfTest(SelfTestSaveRequestDto requestDto, double kcal, double weight, int exercise) {
        selfTestService.update(requestDto.toEntity());
        return "/selftest/SelfTest";
    }

    @GetMapping("")
    public String SelfTestFoundation() {
        return "/selftest/SelfTestFoundation";
    }
}

