package com.nata.ruchki.controller;

import com.nata.ruchki.data.service.CategoryService;
import com.nata.ruchki.data.value.CategoriesValue;
import com.nata.ruchki.data.value.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private CategoryService categoryService;


    public HelloController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Model<Long> addCategory(@RequestBody CategoriesValue categoriesValue) {
        Long id = categoryService.add(categoriesValue);
        return new Model<>(id);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    public CategoriesValue updateCategory(@RequestBody CategoriesValue categoriesValue) {
        return categoryService.update(categoriesValue);
    }

    @RequestMapping(value = "/category/list", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
    public List<CategoriesValue> listCategory() {
        return categoryService.list();
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
    public CategoriesValue category(@PathVariable Long id) {
        return categoryService.find(id);
    }
}