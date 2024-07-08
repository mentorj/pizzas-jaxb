package com.javaxpert.katas.pizzas.jaxb;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * An order contains Pizzas and may be more products
 */
@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    public Order() {
        date=Instant.now();
    }

    @XmlElement(name = "orderedAt")
    @XmlJavaTypeAdapter(XmlInstantAdapter.class)
    private Instant date;
    @XmlElement(name = "pizza")
    private List<Pizza> pizzaList;

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return  Objects.equals(pizzaList, order.pizzaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, pizzaList);
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
}
