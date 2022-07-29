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

        if (health == null) {
            return "redirect:/health/new";
        } else {
            diet.setDiet_id(health.getMember_id());
            diet = dietService.findDiet(diet.getDiet_id());

            if(diet == null) {
                dietService.save(product, health);

                diet = new Diet();
                diet.setDiet_id(health.getMember_id());
                diet = dietService.findDiet(diet.getDiet_id());

                Product product1 = dietService.findMonday(diet.getMonday());
                Product product2 = dietService.findTuesday(diet.getTuesday());
                Product product3 = dietService.findWednesday(diet.getWednesday());
                Product product4 = dietService.findThursday(diet.getThursday());
                Product product5 = dietService.findFriday(diet.getFriday());
                model.addAttribute("product1", product1);
                model.addAttribute("product2", product2);
                model.addAttribute("product3", product3);
                model.addAttribute("product4", product4);
                model.addAttribute("product5", product5);

                member.setMember_id(health.getMember_id());
                member = healthService.findMember(member.getMember_id());
                model.addAttribute("name", member.getName());
            } else {
                diet = dietService.findDiet(diet.getDiet_id());

                Product product1 = dietService.findMonday(diet.getMonday());
                Product product2 = dietService.findTuesday(diet.getTuesday());
                Product product3 = dietService.findWednesday(diet.getWednesday());
                Product product4 = dietService.findThursday(diet.getThursday());
                Product product5 = dietService.findFriday(diet.getFriday());
                model.addAttribute("product1", product1);
                model.addAttribute("product2", product2);
                model.addAttribute("product3", product3);
                model.addAttribute("product4", product4);
                model.addAttribute("product5", product5);

                member.setMember_id(health.getMember_id());
                member = healthService.findMember(member.getMember_id());
                model.addAttribute("name", member.getName());
            }

            return "/diet/diets";
        }


    }
}
