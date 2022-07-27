package agaig.justeat.diet.controller;

import agaig.justeat.diet.domain.Health;
import agaig.justeat.member.domain.Member;
import agaig.justeat.diet.service.HealthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/health")
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("")
    public String memberHealth(HttpSession session, Health health, Member member, Model model) {
        health.setMember_id((Long) session.getAttribute("session"));
        health = healthService.findHealth(health.getMember_id());

        if (health.isHealthFlag()) {
            member.setMember_id(health.getMember_id());
            member = healthService.findMember(member.getMember_id());
            model.addAttribute("health", health);
            model.addAttribute("name", member.getName());

            return "/health/memberHealth";
        } else {
            return "redirect:/new";
        }
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
