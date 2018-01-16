package com.nata.ruchki.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Natalia Levchenko
 */

@SuppressWarnings("unused")
@Entity
@Table(name = "categories")
public class Categories implements Serializable {

    private Long id;
    private String name;
    private List<Products> products;

    public Categories() {
    }

    public Categories(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category")
    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
