package com.nata.ruchki.data.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Oleg Zaidullin
 */
@Entity
@Table(name = "test")
public class Test implements Serializable {

    private Long id;
    private String message;

    public Test() {}

    public Test(String message) {
        this.message = message;
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

    @Column(name = "message", nullable = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
