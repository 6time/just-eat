package agaig.justeat.diet.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Health {
    private Long member_id;
    private double height;
    private double weight;
    private double goal;
    private String compare_weight;
    private int goal_week;
    private int kcal_max;
    private int kcal_min;
    private int protein_max;
    private int protein_min;
    private int carb_max;
    private int carb_min;
    private int fat_max;
    private int fat_min;
    private double exercise;
    private double exerciseNumber;

    public Health(Long member_id, double height, double weight, double goal, String compare_weight, int goal_week,
                  int kcal_max, int kcal_min, int protein_max, int protein_min, int carb_max, int carb_min, int fat_max, int fat_min,
                  double exercise, double exerciseNumber) {
        this.member_id = member_id;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
        this.compare_weight = compare_weight;
        this.goal_week = goal_week;
        this.kcal_max = kcal_max;
        this.kcal_min = kcal_min;
        this.protein_max = protein_max;
        this.protein_min = protein_min;
        this.carb_max = carb_max;
        this.carb_min = carb_min;
        this.fat_max = fat_max;
        this.fat_min = fat_min;
        this.exerciseNumber = exerciseNumber;
        this.exercise = exercise;

    }
}
