package com.nata.ruchki.data.value;

import java.util.Objects;

/**
 * @author Oleg Zaidullin
 */
public class TestValue {
    private Long id;
    private String message;

    public TestValue() {
    }

    public TestValue(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestValue testValue = (TestValue) o;
        return Objects.equals(id, testValue.id) &&
                Objects.equals(message, testValue.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }
}
