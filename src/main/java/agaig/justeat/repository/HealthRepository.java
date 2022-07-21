package agaig.justeat.repository;

import agaig.justeat.domain.Health;
import agaig.justeat.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface HealthRepository {
    Optional<Health> findByHealthFlag(boolean health_flag);
    Optional<Member> findByName(String name);
    Optional<Member> findByBirth(String birth);
    Optional<Member> findByGender(String gender);
    Health save(Health health);

}
