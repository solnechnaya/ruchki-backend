package com.nata.ruchki.data.repository;

import com.nata.ruchki.data.entity.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Natalia Levchenko
 */
//создание нового репозитория, наследуется от CrudRepository, позволяет использовать его методы сохранения, нахождения, удаления
public interface ProductsRepo extends CrudRepository<Products, Long> {

    @Query("select p from Products p where p.name like ?1 and p.descr like ?2")
    List<Products> search(String author, String title);

}
