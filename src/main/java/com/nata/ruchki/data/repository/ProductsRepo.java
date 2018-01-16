package com.nata.ruchki.data.repository;

import com.nata.ruchki.data.entity.Products;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Natalia Levchenko
 */

public interface ProductsRepo extends CrudRepository<Products, Long> {
}
