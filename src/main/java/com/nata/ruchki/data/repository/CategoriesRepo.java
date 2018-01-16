package com.nata.ruchki.data.repository;

import com.nata.ruchki.data.entity.Categories;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Natalia Levchenko
 */

public interface CategoriesRepo extends CrudRepository<Categories, Long> {
}
