package agaig.justeat.domain;

public class MemberHealth {
    private Long member_id;
    private Double height;
    private Double weight;
    private Double goal;
    private String exercise;
    private Double bmr;
    private Double amr;
    private Double kcal;
    private Double protein;
    private Double carbo;
    private Double fat;

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    } 
    
    public Double getBmr() {
        return bmr;
    }

    public void setBmr(Double bmr) {
        this.bmr = bmr;
    }
    
    public Double getAmr() {
        return amr;
    }

    public void setAmr(Double amr) {
        this.amr = amr;
    }
    
    public Double getKcal() {
        return kcal;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCarbo() {
        return carbo;
    }

    public void setCarbo(Double carbo) {
        this.carbo = carbo;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }
}
