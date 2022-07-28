package agaig.justeat.diet.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    private Long product_id;
    private String product_name;
    private int product_size;
    private int kcal;
    private int protein;
    private int carb;
    private int fat;
    private int sugars;
    private int sodium;
    private int price;

    public Product(Long product_id, String product_name, int product_size, int kcal, int protein, int carb, int fat, int sugars, int sodium, int price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_size = product_size;
        this.kcal = kcal;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;
        this.sugars = sugars;
        this.sodium = sodium;
        this.price = price;
    }
}
