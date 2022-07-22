package agaig.justeat.repository;

import agaig.justeat.domain.Health;
import agaig.justeat.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface HealthRepository {
    Optional<Member> findByName(String name);
    Optional<Member> findByBirth(String birth);
    Optional<Member> findByGender(String gender);
    Long insert(Health health);
    List<Health> findAll();
}
