package agaig.justeat.diet.repository;

import agaig.justeat.diet.domain.Health;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthRepository {

    Long insert(Health health);
    Health findHealth(Long id);

}
