package ua.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Ingredient;

public interface IngredientRepository extends JpaNameRepository<Ingredient>, JpaSpecificationExecutor<Ingredient> {

//	@Query("SELECT new ua.model.view.IngredientView(i.id, i.name) FROM Ingredient i")
//	List<IngredientView> findAllView();
	
//	@Query(value = "SELECT new ua.model.view.IngredientView(i.id, i.name) FROM Ingredient i", 
//			countQuery = "SELECT count(i.id) FROM Ingredient i")
//	Page<IngredientView> findAllView(Pageable pageable);
//	
//	@Query("SELECT i FROM Ingredient i WHERE i.id=?1")
//	Ingredient findOneRequest(Integer id);
}
