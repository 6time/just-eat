package agaig.justeat.health.controller;

import agaig.justeat.health.domain.Health;
import agaig.justeat.health.service.HealthService;
import agaig.justeat.member.domain.Member;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/health")
    public String memberHealth(Model model) {
        List<Health> memberHealth = healthService.findAll();
        model.addAttribute("health", memberHealth);

        return "/health/memberHealth";
    }

    @GetMapping("/health/new")
    public String healthTest() {
        return "/health/healthTest";
    }

    @PostMapping("/health/new")
    public String save(HttpSession session, MemberUpdateResponseDto responseDto, Member member, Health health, String gender) {
        responseDto = (MemberUpdateResponseDto) session.getAttribute("session");
        health.setMember_id(responseDto.getMember_id());
        healthService.save(health, member,gender);
        return "redirect:/health";
    }


}
