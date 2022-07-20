package agaig.justeat.repository;

import agaig.justeat.domain.Health;
import agaig.justeat.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryHealthRepository implements HealthRepository {

    private static Map<Long, Member> memberMap = new HashMap<>();
    private static Map<Long, Health> healthMap = new HashMap<>();
    private static Long count = 0L;
    @Override
    public Optional<Health> findByHealthFlag(boolean health_flag) {
        return Optional.ofNullable(healthMap.get(health_flag));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.ofNullable(memberMap.get(name));
    }

    @Override
    public Optional<Member> findByBirth(String birth) {
        return Optional.ofNullable(memberMap.get(birth));
    }

    @Override
    public Optional<Member> findByGender(String gender) {
        return Optional.ofNullable(memberMap.get(gender));
    }

    @Override
    public Health save(Health health) {
        health.setMember_id(++count);
        healthMap.put(health.getMember_id(), health);
        return health;
    }
}
