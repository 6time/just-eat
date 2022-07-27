package agaig.justeat.selftest.controller;

import agaig.justeat.member.dto.MemberUpdateResponseDto;
import agaig.justeat.member.service.MemberService;
import agaig.justeat.selftest.domain.SelfTest;
import agaig.justeat.selftest.dto.SelfTestSaveRequestDto;
import agaig.justeat.selftest.service.SelfTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class SelfTestController { //controller 프레젠테이션 계층으로 클라이언트의 요청을 처리

    private final SelfTestService selfTestService;
    private final MemberService memberService;

    @Autowired
    public SelfTestController(SelfTestService selfTestService, MemberService memberService) {
        this.selfTestService = selfTestService;
        this.memberService = memberService;
    }

    @PostMapping("selftest")
    public String SelfTest(HttpSession session, SelfTestSaveRequestDto requestDto, int daykcal, int dayweight, int dayexercise, Model model) {
        selfTestService.save(requestDto.toEntity());
        return "/selftest/SelfTest";
    }

    @GetMapping("selftest")
    public String SelfTestFoundation(SelfTestSaveRequestDto requestDto, HttpSession session, Model model) {
        MemberUpdateResponseDto responseDto = memberService.findInfoById((Long) session.getAttribute("session"));
        model.addAttribute("name", responseDto.getName());
        return "/selftest/SelfTestFoundation";
    }

    @GetMapping("list")
    public String list(HttpSession session, Model model) {
        List<SelfTest> selfTests = selfTestService.findMembers((Long) session.getAttribute("session"));
        MemberUpdateResponseDto responseDto = memberService.findInfoById((Long) session.getAttribute("session"));
        model.addAttribute("name", responseDto.getName());
        model.addAttribute("selfTests", selfTests);
        return "selftest/SelfTestList";
    }

}


