package agaig.justeat.diet.controller;

import agaig.justeat.diet.domain.Diet;
import agaig.justeat.diet.domain.Health;
import agaig.justeat.diet.domain.Product;
import agaig.justeat.diet.service.DietService;
import agaig.justeat.diet.service.HealthService;
import agaig.justeat.member.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/diet")
public class DietController {
    private final DietService dietService;
    private final HealthService healthService;

    public DietController(DietService dietService, HealthService healthService) {
        this.dietService = dietService;
        this.healthService = healthService;
    }

    @GetMapping("")
    public String memberDiet(HttpSession session, Health health, Product product, Diet diet, Member member, Model model) {
        health.setMember_id((Long) session.getAttribute("session"));
        health = healthService.findHealth(health.getMember_id());

        if (health.isHealthFlag()) {
            diet.setDiet_id(health.getMember_id());
            dietService.save(product, health, diet);
            diet = dietService.findDiet(diet.getDiet_id());
            model.addAttribute("diet", diet);

            member.setMember_id(health.getMember_id());
            member = healthService.findMember(member.getMember_id());
            model.addAttribute("health", health);
            model.addAttribute("name", member.getName());

            return "/diet/diets";
        } else {
            return "redirect:/health/new";
        }


    }
}
