package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Ingredient;
import ua.model.view.IngredientView;

public interface IngredientService extends CrudService<Ingredient, Integer> {

	Page<IngredientView> findAllView(Pageable pageable);

}
