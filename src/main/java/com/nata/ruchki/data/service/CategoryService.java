package com.nata.ruchki.data.service;

import com.nata.ruchki.data.entity.Categories;
import com.nata.ruchki.data.repository.CategoriesRepo;
import com.nata.ruchki.data.value.CategoriesValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoriesRepo categoriesRepo;

    public CategoryService(CategoriesRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    public Long add(CategoriesValue categoriesValue) {
        Categories result = categoriesRepo.save(toEntity(categoriesValue));
        return result.getId();
    }

    public CategoriesValue find(Long id) {
        return toValue(categoriesRepo.findOne(id));
    }

    private CategoriesValue toValue(Categories entity) {
        return new CategoriesValue(entity.getId(), entity.getName());
    }

    private Categories toEntity(CategoriesValue categoriesValue) {
        return new Categories(categoriesValue.getName());
    }

    public CategoriesValue update(CategoriesValue categoriesValue) {
        Categories c = categoriesRepo.findOne(categoriesValue.getId());
        c.setName(categoriesValue.getName());
        categoriesRepo.save(c);
        return toValue(c);
    }

    public List<CategoriesValue> list() {
        Iterable<Categories> iterable = categoriesRepo.findAll();
        List<Categories> list = new ArrayList<>();
        iterable.forEach(list::add);
       /* List<CategoriesValue> values = new ArrayList<>();
            for (Categories c : list) {
            CategoriesValue categoriesValue = toValue(c);
            values.add(categoriesValue);
            }
            return values;*/
        return list.stream().map(this::toValue).collect(Collectors.toList());
    }
}
