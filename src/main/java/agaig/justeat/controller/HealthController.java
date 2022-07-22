package agaig.justeat.controller;

import agaig.justeat.domain.Health;
import agaig.justeat.member.domain.Member;
import agaig.justeat.service.HealthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        healthService.healthTest(health,member);
        int goalWeek = health.getGoalWeek();
        int dailyKcal = health.getDailyKcal();
        model.addAttribute("goalWeek", goalWeek);
        model.addAttribute("dailyKcal", dailyKcal);
        return "/health/memberHealth";
    }
}
