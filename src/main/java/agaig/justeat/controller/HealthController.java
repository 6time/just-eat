package agaig.justeat.controller;

import agaig.justeat.domain.Health;
import agaig.justeat.service.HealthService;
import org.springframework.stereotype.Controller;
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
    public String healthTest(Health health) {

        return "/health/healthTest";
    }

    @PostMapping("")
    public String health() {

        return "/health/memberHealth";
    }
}
