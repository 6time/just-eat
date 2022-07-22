package agaig.justeat.health.controller;

import agaig.justeat.health.domain.Health;
import agaig.justeat.member.domain.Member;
import agaig.justeat.health.service.HealthService;
import agaig.justeat.member.dto.MemberResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/health")
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("")
    public String healthTest() {
        return "/health/healthTest";
    }

    @PostMapping("")
    public String health(HttpSession session, Health health, Model model, Member member, MemberResponseDto responseDto) {
        responseDto = (MemberResponseDto) session.getAttribute("session");
        member.setName("기유진");
        member.setBirth("19931217");
        member.setGender("여");
        health.setMember_id(responseDto.getMember_id());
        healthService.save(health,member);
        List<Health> memberHealth = healthService.memberHealth();
        model.addAttribute("health", memberHealth);
        return "/health/memberHealth";
    }
}
