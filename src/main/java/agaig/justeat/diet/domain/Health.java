package agaig.justeat.diet.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Health {
    private Long member_id;
    private boolean healthFlag;
    private double height;
    private double weight;
    private double goal;
    private String compareWeight;
    private int goalWeek;
    private int kcal;
    private int proteinMax;
    private int proteinMin;
    private int carbMax;
    private int carbMin;
    private int fatMax;
    private int fatMin;
    private double exercise;
    private double exerciseNumber;

    public Health(Long member_id,boolean healthFlag, double height, double weight, double goal, String compareWeight, int goalWeek,
                  int kcal, int proteinMax, int proteinMin, int carbMax, int carbMin, int fatMax, int fatMin,
                  double exercise, double exerciseNumber) {
        this.member_id = member_id;
        this.healthFlag = healthFlag;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
        this.compareWeight = compareWeight;
        this.goalWeek = goalWeek;
        this.kcal = kcal;
        this.proteinMax = proteinMax;
        this.proteinMin = proteinMin;
        this.carbMax = carbMax;
        this.carbMin = carbMin;
        this.fatMax = fatMax;
        this.fatMin = fatMin;
        this.exerciseNumber = exerciseNumber;
        this.exercise = exercise;

    }
}
