package agaig.justeat.health.controller;

import agaig.justeat.health.domain.Health;
import agaig.justeat.member.domain.Member;
import agaig.justeat.health.service.HealthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String health(Health health, Model model, Member member) {
        member.setName("기유진");
        member.setBirth("19931217");
        member.setGender("여");
        healthService.save(health,member);
        List<Health> memberHealth = healthService.memberHealth();
        model.addAttribute("health", memberHealth);
        return "/health/memberHealth";
    }
}
