package com.nata.ruchki.data.value;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Natalia Levchenko
 */

@SuppressWarnings("unused")
public class ProductsValue {
    private Long id;
    private String name;
    private String shortDescr;
    private String descr;
    private Byte[] picture;
    private Long categoriesId;

    public ProductsValue() {

    }

    public ProductsValue(Long id, String name, String shortDescr, String descr, Byte[] picture, Long categoriesId) {

        this.id = id;
        this.name = name;
        this.shortDescr = shortDescr;
        this.descr = descr;
        this.picture = picture;
        this.categoriesId = categoriesId;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescr() {
        return shortDescr;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }

    public Long getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Long categoriesId) {
        this.categoriesId = categoriesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsValue that = (ProductsValue) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(shortDescr, that.shortDescr) &&
                Objects.equals(descr, that.descr) &&
                Arrays.equals(picture, that.picture) &&
                Objects.equals(categoriesId, that.categoriesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortDescr, descr, picture, categoriesId);
    }
}
