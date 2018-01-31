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

@Service // говорит о том, что в этом классе осуществляется бизнес-логика
public class ProductService {

    private ProductsRepo productRepo;
    private CategoriesRepo categoriesRepo;

    public ProductService(ProductsRepo productRepo, CategoriesRepo categoriesRepo) {
        this.productRepo = productRepo;
        this.categoriesRepo = categoriesRepo;
    }

    private ProductsValue toValue(Products entity) { //преобразование entity в объект ProductsValue
        return new ProductsValue(
                entity.getId(), entity.getName(), entity.getShortDescr(), entity.getDescr(),
                entity.getPicture(), entity.getCategory().getId(), entity.getCategory().getName()
        );
    }

    private Products toEntity(ProductsValue productsValue) { //преобразование объектов ProductsValue в entity
        byte[] picture = new byte[1];
        picture[0] = 0;
        Categories category = categoriesRepo.findOne(productsValue.getCategoriesId());
        return new Products(productsValue.getName(), productsValue.getShortDescr(), productsValue.getDescr(), picture, category);
    }

    public Long add(ProductsValue productsValue) {//метод добавления нового продукта
        Products result = productRepo.save(toEntity(productsValue));//в result сохраняется преобразованное entity
        return result.getId(); //возвращает result с определенным id
    }

    public ProductsValue update(ProductsValue productsValue) { //метод обновления продукта
        Products product = productRepo.findOne(productsValue.getId());//находит продукт по id
        product.setName(productsValue.getName());//переписывает имя
        product.setShortDescr(productsValue.getShortDescr());//кр содержание
        product.setDescr(productsValue.getDescr());//содержание
        productRepo.save(product);//сохраняет
        return toValue(product); //возвращает преобразованный объект типа ProductValue
    }

    public ProductsValue find(Long id) {//находит продукт по id
        return toValue(productRepo.findOne(id));
    }

    public List<ProductsValue> list() {//выводит список всех продуктов
        Iterable<Products> iterable = productRepo.findAll();//
        List<Products> list = new ArrayList<>();//новый список
        iterable.forEach(list::add);//перебирает
        return list.stream().map(this::toValue).collect(Collectors.toList());
    }

    public void upload(byte[] x, Long id) { // загрузка картинки в определенный продукт
        Products products = productRepo.findOne(id);
        products.setPicture(x);
        productRepo.save(products);
    }

    public byte[] download(Long id) { //загрузка определенной картинки на комп
        Products products = productRepo.findOne(id);
        return products.getPicture();
    }
}

