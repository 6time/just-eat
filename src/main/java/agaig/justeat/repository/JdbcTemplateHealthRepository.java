package agaig.justeat.repository;

import agaig.justeat.domain.Health;
import agaig.justeat.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Optional;

public class JdbcTemplateHealthRepository implements HealthRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateHealthRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Optional<Health> findByHealthFlag(boolean health_flag) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByBirth(String birth) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByGender(String gender) {
        return Optional.empty();
    }

    @Override
    public Health save(Health health) {
        return null;
    }

}
