package agaig.justeat.health.service;

import agaig.justeat.health.domain.Health;
import agaig.justeat.health.repository.HealthRepository;
import agaig.justeat.member.domain.Member;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import agaig.justeat.member.repository.MemberRepository;
import agaig.justeat.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    public void Calculation(Health health, Member member) {
        compareWeight(health);
        dailyKcal(health, member);
        health.setHealthFlag(true);
    }

    public void save(Health health,Member member) {
        Calculation(health, member);
        healthRepository.insert(health);
    }

    public Health findHealth(Long id) {
        Health health = healthRepository.findHealth(id);
        return health;
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
        /*if (health.getKcal() == 1000 && health.getKcal() < 1000) {
            health.setKcal(1000);
        }*/
    }

    public void protein() {

    }

    public void carb() {

    }

    public void fat() {

    }
}
