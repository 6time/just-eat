package agaig.justeat.controller;

import agaig.justeat.dto.SelfTestSaveRequestDto;
import agaig.justeat.repository.SelfTestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/selftest")
public class SelfTestController { //controller 프레젠테이션 계층으로 클라이언트의 요청을 처리

    public final SelfTestRepository selfTestRepository;
    public SelfTestController(SelfTestRepository selfTestRepository) {
        this.selfTestRepository = selfTestRepository;
    }

    @PostMapping("")
    public String SelfTest(SelfTestSaveRequestDto requestDto, double kcal, double weight, int exercise) {
        selfTestRepository.update(requestDto.toEntity());
        return "/selftest/SelfTest";
    }

    @GetMapping("")
    public String SelfTestFoundation() {
        return "/selftest/SelfTestFoundation";
    }
}

