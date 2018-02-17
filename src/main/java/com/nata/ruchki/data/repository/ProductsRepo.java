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

    @Query("select p from Products p where p.name like ?1 or p.descr like ?1")
//аннотация Query позволяет создать специальный запрос к БД
    List<Products> search(String s);            //like(вхождение) - подобно, ?1(позиции параметров метода)

}
