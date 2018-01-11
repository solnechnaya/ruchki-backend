package com.nata.ruchki.data.value;

/**
 * @author Oleg Zaidullin
 */
public class Model<T> {

    public T getValue() { return value; }

    private T value = null;

    public void setValue(T newValue) { value = newValue; }

    @SuppressWarnings("WeakerAccess")
    public Model()                   {}

    public Model(T value) {
        this();
        this.value = value;
    }
}

