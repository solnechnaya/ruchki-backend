package com.nata.ruchki.data.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Natalia Levchenko
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "products")
public class Products implements Serializable {

    private Long id;
    private String name;
    private String shortDescr;
    private String descr;
    private Byte[] picture;
    private Categories category;

    public Products() {
    }

    public Products(String name, String shortDescr, String descr, Byte[] picture, Categories category) {
        this.name = name;
        this.shortDescr = shortDescr;
        this.descr = descr;
        this.picture = picture;
        this.category = category;
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

    @Column(name = "short_descr", nullable = false)
    public String getShortDescr() {
        return shortDescr;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    @Column(name = "descr")
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Column(name = "picture", nullable = false)
    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }

    @ManyToOne()
    @JoinColumn(name = "categories_id", nullable = false)
    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

}
