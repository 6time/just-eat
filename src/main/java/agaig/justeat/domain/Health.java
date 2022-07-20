package agaig.justeat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Health {
    private Long member_id;
    private Boolean health_flag;
    private Double height;
    private Double weight;
    private Double goal;
    private Double exercise;
    private Double exerciseNumber;
    private String compareWeight;
    private Integer goalWeek;
    private Integer dailyKcal;
    private Double protein;
    private Double carbo;
    private Double fat;

    public Health(Long member_id, Boolean health_flag, Double height, Double weight, Double goal, Double exercise, Double exerciseNumber, String compareWeight, Integer goalWeek, Integer dailyKcal, Double protein, Double carbo, Double fat) {
        this.member_id = member_id;
        this.health_flag = health_flag;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
        this.exercise = exercise;
        this.exerciseNumber = exerciseNumber;
        this.compareWeight = compareWeight;
        this.goalWeek = goalWeek;
        this.dailyKcal = dailyKcal;
        this.protein = protein;
        this.carbo = carbo;
        this.fat = fat;

    }
}
