package agaig.justeat.repository;

import agaig.justeat.domain.Health;
import agaig.justeat.domain.Member;

import java.util.List;
import java.util.Optional;

public interface HealthRepository {
    Optional<Health> findByHealthFlag(boolean health_flag);
    Optional<Member> findByName(String name);
    Optional<Member> findByBirth(String birth);
    Optional<Member> findByGender(String gender);
    Health save(Health health);

}
