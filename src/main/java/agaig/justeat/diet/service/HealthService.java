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

    public void save(Health health) {
        healthRepository.insert(health);
    }

    public void update(Health health) {
        healthRepository.update(health);
    }

    public void calculation(Health health, Member member) {
        compareWeight(health);
        dailyKcal(health, member);
        calculationPCF(health, member);
    }

    public void compareWeight(Health health) {
        double weight = health.getWeight();
        double goal = health.getGoal();
        if(weight > goal) {
            health.setCompare_weight("감량");
            health.setGoal_week((int)weight - (int)goal);
        } else if(weight == goal) {
            health.setCompare_weight("유지");
            health.setGoal_week((int)goal - (int)weight);
        } else if(weight < goal) {
            health.setCompare_weight("증량");
            health.setGoal_week((int)goal - (int)weight);
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
        double kcal = amr * bmr;

        if(health.getCompare_weight().equals("감량")) {
            health.setKcal_max((int) (kcal * 0.9));
            health.setKcal_min((int) (kcal * 0.8));
        } else if(health.getCompare_weight().equals("유지")) {
            health.setKcal_max((int) (kcal * 0.9));
            health.setKcal_min((int) (kcal * 0.8));
        } else if(health.getCompare_weight().equals("증량")) {
            health.setKcal_max((int) kcal + 1000);
            health.setKcal_min((int) kcal + 500);
        }

        if (health.getKcal_min() == 1000 || health.getKcal_min() < 1000) {
            health.setKcal_min(1000);
            health.setKcal_max(1200);
        }
    }

    public void calculationPCF(Health health, Member member) {
        protein(health);
        fat(health);
        carb(health);
    }

    public void protein(Health health){
        double weight = health.getWeight();

        if(health.getCompare_weight().equals("감량")) {
            health.setProtein_max((int) (weight * 2.2));
            health.setProtein_min((int) (weight * 1.6));
        } else if(health.getCompare_weight().equals("유지")) {
            health.setProtein_max((int) (weight * 2.2));
            health.setProtein_min((int) (weight * 1.7));
        } else if(health.getCompare_weight().equals("증량")) {
            health.setProtein_max((int) (weight * 2.2));
            health.setProtein_min((int) (weight * 1.8));
        }
    }

    public void fat(Health health){
        int kcal_min = health.getKcal_min();

        health.setFat_max((int) (kcal_min * 0.3 / 9));
        health.setFat_min((int) (kcal_min * 0.2 / 9));
    }

    public void carb(Health health){
        int kcal_min = health.getKcal_min();
        int p_max = health.getProtein_max();
        int p_min = health.getProtein_min();
        int f_max = health.getFat_max();
        int f_min = health.getFat_min();

        health.setCarb_max(kcal_min - ((p_min * 4) + (f_min * 9)));
        health.setCarb_min(kcal_min - ((p_max * 4) + (f_max * 9)));
    }
}
