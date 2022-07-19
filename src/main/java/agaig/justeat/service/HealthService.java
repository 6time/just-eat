package agaig.justeat.service;

import agaig.justeat.domain.Health;
import agaig.justeat.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthService {
    private final HealthRepository healthRepository;

    @Autowired
    public HealthService(HealthRepository healthRepository) {

        this.healthRepository = healthRepository;
    }



}
