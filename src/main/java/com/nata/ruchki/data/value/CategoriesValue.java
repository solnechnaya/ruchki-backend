package com.nata.ruchki.data.value;

import java.util.Objects;

/**
 * @author Natalia Levchenko
 */

@SuppressWarnings("unused")
public class CategoriesValue {

    private Long id;
    private String name;

    // пустой конструктор, нужен для
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

    public void setName(String name) {
        this.name = name;
    }

    @Override  //@Override - для переопределения метода базового класса.
    //если в базовом классе не окажется метода с аналогичной сигнатурой, то мы получим предупреждение компилятора о том, что этого не произошло.
    //Аннотация  никак не влияет на сам факт переопределения метода - при совпадении сигнатур с методом базового класса он и так будет переопределен,
    //она служит лишь для контроля успешности действия при сборке проекта
    //http://info.javarush.ru/Coder/2015/09/23/Перегрузка-методов-equals-и-hashCode-в-Java.html
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

