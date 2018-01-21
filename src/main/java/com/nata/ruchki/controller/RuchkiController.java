package com.nata.ruchki.controller;

import com.nata.ruchki.data.service.CategoryService;
import com.nata.ruchki.data.service.ProductService;
import com.nata.ruchki.data.value.CategoriesValue;
import com.nata.ruchki.data.value.Model;
import com.nata.ruchki.data.value.ProductsValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SuppressWarnings("ALL")
@RestController
public class RuchkiController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private CategoryService categoryService;
    private ProductService productService;

    public RuchkiController(CategoryService categoryService, ProductService productService) {

        this.categoryService = categoryService;
        this.productService = productService;
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

    @RequestMapping(value = "/category/list", method = RequestMethod.GET, produces = {"application/json"})
    public List<CategoriesValue> listCategory() {
        return categoryService.list();
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
    public CategoriesValue category(@PathVariable Long id) {
        return categoryService.find(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Model<Long> addProduct(@RequestBody ProductsValue productsValue) {
        Long id = productService.add(productsValue);
        return new Model<>(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    public ProductsValue updateProduct(@RequestBody ProductsValue productsValue) {
        return productService.update(productsValue);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
    public ProductsValue products(@PathVariable Long id) {
        return productService.find(id);
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
    public List<ProductsValue> listProducts() {
        return productService.list();
    }
}