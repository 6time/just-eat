package agaig.justeat.service;

import agaig.justeat.domain.Health;
import agaig.justeat.domain.Member;
import agaig.justeat.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class HealthService {
    private final HealthRepository healthRepository;

    @Autowired
    public HealthService(HealthRepository healthRepository) {

        this.healthRepository = healthRepository;
    }

    public void healthTest(Health health,Member member) {
        compareWeight(health);
        dailyKcal(health, member);
    }
    private int americanAge(Member member) {
        int age;
        LocalDate now = LocalDate.now();
        LocalDate birth = LocalDate.parse(member.getBirth(), DateTimeFormatter.ofPattern("yyyyMMdd"));

        age = now.minusYears(birth.getYear()).getYear();

        if (birth.plusYears(age).isAfter(now)) {
            age = age -1;
        }
        return age;
    }

    public void compareWeight(Health health) {
        double weight = health.getWeight();
        double goal = health.getGoal();

        if(weight > goal) {
            health.setCompareWeight("감량");
            health.setGoalWeek((int)weight - (int)goal);
        } else if(weight == goal) {
            health.setCompareWeight("유지");
            health.setGoalWeek((int)goal - (int)weight);
        } else if(weight < goal) {
            health.setCompareWeight("증량");
            health.setGoalWeek((int)goal - (int)weight);
        }
    }

    private double amr(Health health, Member member) {
        double amr = 0;
        if (member.getGender().equals("남")) {
            amr = 88.4 + (13.4 * health.getWeight()) + (4.8 * health.getHeight()) - (5.68 * americanAge(member));
        } else if (member.getGender().equals("여")) {
            amr = 447.6 + (9.25 * health.getWeight()) + (3.1 * health.getHeight()) - (4.33 * americanAge(member));
        }
        return amr;
    }

    public void dailyKcal(Health health, Member member) {
        double amr = amr(health, member);
        double bmr = health.getExercise() + health.getExerciseNumber();

        if(health.getCompareWeight().equals("감량")) {
            health.setDailyKcal((int) (amr * bmr - 500.0));
        } else if(health.getCompareWeight().equals("유지")) {
            health.setDailyKcal((int) (amr * bmr));
        } else if(health.getCompareWeight().equals("증량")) {
            health.setDailyKcal((int) (amr * bmr + 300.0));
        }
    }

    public void protein() {

    }

    public void carb() {

    }

    public void fat() {

    }

}
