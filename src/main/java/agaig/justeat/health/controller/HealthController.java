package agaig.justeat.health.controller;

import agaig.justeat.health.domain.Health;
import agaig.justeat.member.domain.Member;
import agaig.justeat.health.service.HealthService;
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
    public String memberHealth(HttpSession session, Health health, Model model) {
        health.setMember_id((Long) session.getAttribute("session"));
        health = healthService.findHealth(health.getMember_id());
        System.out.println(health.getKcal());
        model.addAttribute("health", health);

        return "/health/memberHealth";
    }

    @GetMapping("new")
    public String healthTest() {
        return "/health/healthTest";
    }

    @PostMapping("new")
    public String save(HttpSession session, Member member, Health health) {
        member.setMember_id((Long) session.getAttribute("session"));
        health.setMember_id(member.getMember_id());
        member = healthService.findMember(member.getMember_id());
        healthService.save(health, member);

        return "redirect:/health";
    }


}
