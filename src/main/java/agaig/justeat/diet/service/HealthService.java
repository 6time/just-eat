package agaig.justeat.diet.service;

import agaig.justeat.diet.domain.Health;
import agaig.justeat.diet.repository.HealthRepository;
import agaig.justeat.member.domain.Member;
import agaig.justeat.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class HealthService {
    private final HealthRepository healthRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public HealthService(HealthRepository healthRepository, MemberRepository memberRepository) {

        this.healthRepository = healthRepository;
        this.memberRepository = memberRepository;
    }

    public Member findMember(Long id) {
        Member member = memberRepository.findById(id);
        return member;
    }

    public Health findHealth(Long id) {
        Health health = healthRepository.findHealth(id);
        return health;
    }

    public void save(Health health,Member member) {
        Calculation(health, member);
        healthRepository.insert(health);
    }

    public void Calculation(Health health, Member member) {
        compareWeight(health);
        dailyKcal(health, member);
        calculationPCF(health);
        health.setHealthFlag(true);
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

    private int americanAge(Member member) {
        int age;

        LocalDate now = LocalDate.now();
        LocalDate tempBirth = LocalDate.parse(member.getBirth(), DateTimeFormatter.ofPattern("yyyyMMdd"));

        age = now.minusYears(tempBirth.getYear()).getYear();

        if (tempBirth.plusYears(age).isAfter(now)) {
            age = age -1;
        }
        return age;
    }

    private double amr(Health health, Member member) {
        double amr = 0;

        if (member.getGender().equals("man")) {
            amr = 88.4 + (13.4 * health.getWeight()) + (4.8 * health.getHeight()) - (5.68 * americanAge(member));
        } else if (member.getGender().equals("woman")) {
            amr = 447.6 + (9.25 * health.getWeight()) + (3.1 * health.getHeight()) - (4.33 * americanAge(member));
        }
        return amr;
    }

    public void dailyKcal(Health health, Member member) {
        double amr = amr(health, member);
        double bmr = health.getExercise() + health.getExerciseNumber();

        if(health.getCompareWeight().equals("감량")) {
            health.setKcal((int) (amr * bmr - 500.0));
        } else if(health.getCompareWeight().equals("유지")) {
            health.setKcal((int) (amr * bmr));
        } else if(health.getCompareWeight().equals("증량")) {
            health.setKcal((int) (amr * bmr + 300.0));
        }

        if (health.getKcal() == 1000 || health.getKcal() < 1000) {
            health.setKcal(1000);
        }
    }

    public void calculationPCF(Health health) {
        int kcal = health.getKcal();
        health.setProteinMax((int) (kcal * 0.4));
        health.setProteinMin((int) (kcal * 0.3));
        health.setCarbMax((int) (kcal * 0.55));
        health.setCarbMin((int) (kcal * 0.45));
        health.setFatMax((int) (kcal * 0.25));
        health.setFatMin((int) (kcal * 0.1));

    }
}
