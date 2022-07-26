package agaig.justeat.health.repository;

import agaig.justeat.health.domain.Health;
import agaig.justeat.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface HealthRepository {

    Long insert(Health health);
    Health findHealth(Long id);

}
