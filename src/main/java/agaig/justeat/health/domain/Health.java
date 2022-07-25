package agaig.justeat.health.domain;

import lombok.Builder;
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
    private double protein;
    private double carb;
    private double fat;
    private double exercise;
    private double exerciseNumber;

    @Builder
    public Health(Long member_id, boolean healthFlag, double height, double weight, double goal, String compareWeight, int goalWeek, int kcal, double protein, double carb, double fat, double exercise, double exerciseNumber) {
        this.member_id = member_id;
        this.healthFlag = healthFlag;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
        this.compareWeight = compareWeight;
        this.goalWeek = goalWeek;
        this.kcal = kcal;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;
        this.exerciseNumber = exerciseNumber;
        this.exercise = exercise;

    }
}
