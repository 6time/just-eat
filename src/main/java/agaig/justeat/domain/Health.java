package agaig.justeat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Health {
    private Long member_id;
    private Double height;
    private Double weight;
    private Double goal;
    private Double exercise;
    private Double exerciseNumber;
    private String compareWeight;
    private Integer goalWeek;
    private Integer kcal;
    private Double protein;
    private Double carb;
    private Double fat;

    public Health(Long member_id, Double height, Double weight, Double goal, Double exercise, Double exerciseNumber, String compareWeight, Integer goalWeek, Integer kcal, Double protein, Double carb, Double fat) {
        this.member_id = member_id;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
        this.exercise = exercise;
        this.exerciseNumber = exerciseNumber;
        this.compareWeight = compareWeight;
        this.goalWeek = goalWeek;
        this.kcal = kcal;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;

    }
}
