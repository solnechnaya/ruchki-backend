package com.nata.ruchki.data.value;

import java.util.Objects;

/**
 * @author Natalia Levchenko
 */

@SuppressWarnings("unused")
public class CategoriesValue {

    private Long id;
    private String name;

    public CategoriesValue() {
    }

    public CategoriesValue(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void seName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesValue categoriesValue = (CategoriesValue) o;
        return Objects.equals(id, categoriesValue.id) &&
                Objects.equals(name, categoriesValue.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

