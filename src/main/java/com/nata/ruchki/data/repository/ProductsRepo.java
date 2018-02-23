package com.nata.ruchki.data.repository;

import com.nata.ruchki.data.entity.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Natalia Levchenko
 */
//создание нового репозитория, наследуется от CrudRepository, позволяет использовать его методы сохранения, добавления, удаления
public interface ProductsRepo extends CrudRepository<Products, Long> {

    @Query("select p from Products p where p.name like %:s% or p.descr like %:s%")
//аннотация Query позволяет создать специальный запрос к БД
    List<Products> search(@Param("s") String s);            //like(вхождение) - подобно, %:s%-s-имя переменной параметра,%..%-искать соответсвие везде
    //@Param("s")-для указания соответсвия пареметров, s должно соответсвовать s в @Query
}
