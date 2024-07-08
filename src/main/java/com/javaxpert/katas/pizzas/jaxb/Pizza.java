package com.javaxpert.katas.pizzas.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

/**
 * Pizza entity with JAXB annotations
 */
@XmlRootElement(name = "pizza")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pizza {
    private String name;
    private float price;
    private Size size;

    public Pizza() {
    }

    public Pizza(String name, float price,Size size) {
        this.name = name;
        this.price = price;
        this.size=size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Float.compare(price, pizza.price) == 0 && Objects.equals(name, pizza.name) && size == pizza.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, size);
    }
}
