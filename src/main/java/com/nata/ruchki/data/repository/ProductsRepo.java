package com.nata.ruchki.data.repository;

import com.nata.ruchki.data.entity.Products;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Natalia Levchenko
 */
//создание нового репозитория, наследуется от CrudRepository, позволяет использовать его методы сохранения, нахождения, удаления
public interface ProductsRepo extends CrudRepository<Products, Long> {
}
