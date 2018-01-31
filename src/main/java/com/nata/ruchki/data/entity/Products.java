package com.nata.ruchki.data.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Natalia Levchenko
 */
@SuppressWarnings("unused")
@Entity                    // показывает, что этот класс entity (сущность)
@Table(name = "products") // имя таблицы в БД
public class Products implements Serializable {

    private Long id;
    private String name;
    private String shortDescr;
    private String descr;
    private byte[] picture;
    private Categories category;

    public Products() {
    }

    public Products(String name, String shortDescr, String descr, byte[] picture, Categories category) {
        this.name = name;
        this.shortDescr = shortDescr;
        this.descr = descr;
        this.picture = picture;
        this.category = category;
    }

    @Id  // означает, что это поле является первичным ключем
    @GeneratedValue(strategy = GenerationType.IDENTITY) //генерация id автоматически
    @Column(name = "id", nullable = false) //имя колонки, nullable = false - обязательно должно быть заполненно
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

    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @ManyToOne()// связь между таблицами, отношение много к одному
    @JoinColumn(name = "categories_id", nullable = false)// имя колонки с "сылкой"
    public Categories getCategory() {
        return category;
    }//возвращает в колонку категорию продукта

    public void setCategory(Categories category) {
        this.category = category;
    }

}
