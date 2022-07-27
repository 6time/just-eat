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
        long[] productId = new long[7];

        for (long i=0; i<7; i++) {
            do {
                randomFindProduct(product);
            } while (compareProduct(product, health));

            productId[(int) i] = product.getProduct_id();
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
        int healthKcal = h.getKcal();
        int healthMaxProtein = h.getProteinMax();
        int healthMinProtein = h.getProteinMin();
        int healthMaxCarb = h.getCarbMax();
        int healthMinCarb = h.getCarbMin();
        int healthMaxFat = h.getFatMax();
        int healthMinFat = h.getFatMin();
        boolean result;

        if(healthKcal > p.getKcal() && healthKcal == p.getKcal()
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
}
