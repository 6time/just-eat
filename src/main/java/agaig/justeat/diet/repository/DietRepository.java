package agaig.justeat.diet.repository;

import agaig.justeat.diet.domain.Diet;
import agaig.justeat.diet.domain.Health;
import agaig.justeat.diet.domain.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DietRepository {
    Long insert(Diet diet);
    Long update(Diet diet);
    Product findLastProduct();
    Product findProduct(Long id);
    Diet findDiet(Long id);
}
