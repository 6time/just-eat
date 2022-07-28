package agaig.justeat.diet.service;

import agaig.justeat.diet.domain.Diet;
import agaig.justeat.diet.domain.Health;
import agaig.justeat.diet.domain.Product;
import agaig.justeat.diet.repository.DietRepository;
import agaig.justeat.diet.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietService {
    private final DietRepository dietRepository;
    private final HealthRepository healthRepository;

    @Autowired
    public DietService(DietRepository dietRepository, HealthRepository healthRepository) {
        this.dietRepository = dietRepository;
        this.healthRepository = healthRepository;
    }

    public void save(Product product, Health health, Diet diet) {
        matchingHealth(product, health, diet);
        dietRepository.insert(diet);
    }

    public void matchingHealth(Product product, Health health, Diet diet) {
        long[] id = new long[3];
        long[] productId = new long[7];

        for (long i=0; i<3; i++) {
            do {
                randomFindProduct(product);
                id[(int) i] = product.getProduct_id();
            } while (compareProduct(product, health));

        }

        diet.setMonday(productId[0]);
        diet.setTuesday(productId[1]);
        diet.setWednesday(productId[2]);
        diet.setThursday(productId[3]);
        diet.setFriday(productId[4]);
        diet.setSaturday(productId[5]);
        diet.setSunday(productId[6]);
    }

    public void randomFindProduct(Product product) {
        product = dietRepository.findLastProduct();
        long id = (long)(Math.random() * product.getProduct_id()) + 1;
        product = dietRepository.findProduct(id);
    }

    public boolean compareProduct(Product p, Health h) {
        int healthMaxKcal = h.getKcal_max();
        int healthMinKcal = h.getKcal_min();
        int healthMaxProtein = h.getProtein_max();
        int healthMinProtein = h.getProtein_min();
        int healthMaxCarb = h.getCarb_max();
        int healthMinCarb = h.getCarb_min();
        int healthMaxFat = h.getFat_max();
        int healthMinFat = h.getFat_min();
        boolean result;

        if(healthMaxKcal > p.getKcal() && healthMaxKcal == p.getKcal()
           && healthMinKcal < p.getKcal() && healthMinKcal == p.getKcal()
           && healthMaxProtein > p.getProtein() && healthMaxProtein == p.getProtein()
           && healthMaxCarb > p.getCarb() && healthMaxCarb == p.getCarb()
           && healthMaxFat > p.getFat() && healthMaxFat == p.getFat()
           && healthMinProtein < p.getProtein() && healthMinProtein == p.getProtein()
           && healthMinCarb < p.getCarb() && healthMinCarb == p.getCarb()
           && healthMinFat < p.getFat() && healthMinFat == p.getFat()) {
            result = false;
        } else {
            result = true;
        }

        return result;
    }

    public Diet findDiet(Long id) {
        Diet diet = dietRepository.findDiet(id);
        return diet;
    }

    public Product findMonday(Long id) {
        Product product1 = dietRepository.findProduct(id);

        return product1;
    }

    public Product findTuesday(Long id) {
        Product product2 = dietRepository.findProduct(id);

        return product2;
    }

    public Product findWednesday(Long id) {
        Product product3 = dietRepository.findProduct(id);

        return product3;
    }

    public Product findThursday(Long id) {
        Product product4 = dietRepository.findProduct(id);

        return product4;
    }

    public Product findFriday(Long id) {
        Product product5 = dietRepository.findProduct(id);

        return product5;
    }

    public Product findSaturday(Long id) {
        Product product6 = dietRepository.findProduct(id);

        return product6;
    }

    public Product findSunday(Long id) {
        Product product7 = dietRepository.findProduct(id);

        return product7;
    }

}
