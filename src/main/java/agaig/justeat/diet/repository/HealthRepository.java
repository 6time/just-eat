package agaig.justeat.diet.repository;

import agaig.justeat.diet.domain.Health;
import agaig.justeat.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthRepository {

    Long insert(Health health);
    Long update(Health health);
    Health findHealth(Long id);

}
