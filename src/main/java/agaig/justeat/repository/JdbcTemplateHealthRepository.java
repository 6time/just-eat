package agaig.justeat.repository;

import agaig.justeat.domain.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class JdbcTemplateHealthRepository implements HealthRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateHealthRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Health save(Health health) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("health").usingGeneratedKeyColumns("member_id");

        Map<String, Object> map = new HashMap<>();
        map.put("height", health.getHeight());
        map.put("weight", health.getWeight());
        map.put("goal", health.getGoal());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(map));
        health.setMember_id(key.longValue());
        return health;
    }

    @Override
    public Boolean healthFlag() {
        return null;
    }

    @Override
    public Integer americanAge() {
        return null;
    }

    @Override
    public Health comepareWeight(Health health) {
        double weight = health.getWeight();
        double goal = health.getGoal();

        if(weight > goal){
            health.setCompareWeight("감량");
            health.setGoalWeek((int)weight - (int)goal);
        } else if(weight == goal) {
            health.setCompareWeight("유지");
            health.setGoalWeek((int)weight);
        } else {
            health.setCompareWeight("증량");
            health.setGoalWeek((int)goal - (int)weight);
        }
        return health;
    }

    @Override
    public Integer amr() {
        return null;
    }
}
