package com.nata.ruchki.data.service;

import com.nata.ruchki.data.entity.Categories;
import com.nata.ruchki.data.entity.Products;
import com.nata.ruchki.data.repository.CategoriesRepo;
import com.nata.ruchki.data.repository.ProductsRepo;
import com.nata.ruchki.data.value.ProductsValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductsRepo productRepo;
    private CategoriesRepo categoriesRepo;

    public ProductService(ProductsRepo productRepo, CategoriesRepo categoriesRepo) {
        this.productRepo = productRepo;
        this.categoriesRepo = categoriesRepo;
    }

    private ProductsValue toValue(Products entity) {
        return new ProductsValue(
                entity.getId(), entity.getName(), entity.getShortDescr(), entity.getDescr(),
                entity.getPicture(), entity.getCategory().getId(), entity.getCategory().getName()
        );
    }

    private Products toEntity(ProductsValue productsValue) {
        Byte[] picture = new Byte[1];
        picture[0] = 0;
        Categories category = categoriesRepo.findOne(productsValue.getCategoriesId());
        return new Products(productsValue.getName(), productsValue.getShortDescr(), productsValue.getDescr(), picture, category);
    }

    public Long add(ProductsValue productsValue) {
        Products result = productRepo.save(toEntity(productsValue));
        return result.getId();
    }

    public ProductsValue update(ProductsValue productsValue) {
        Products product = productRepo.findOne(productsValue.getId());
        product.setName(productsValue.getName());
        product.setShortDescr(productsValue.getShortDescr());
        product.setDescr(productsValue.getDescr());
        productRepo.save(product);
        return toValue(product);
    }

    public ProductsValue find(Long id) {
        return toValue(productRepo.findOne(id));
    }

    public List<ProductsValue> list() {
        Iterable<Products> iterable = productRepo.findAll();
        List<Products> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list.stream().map(this::toValue).collect(Collectors.toList());
    }

}

