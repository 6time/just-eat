package agaig.justeat.repository;

import agaig.justeat.domain.Health;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository {
    Health save(Health health);
    Boolean healthFlag();
    Integer americanAge();
    Health comepareWeight(Health health);
    Integer amr();
}
