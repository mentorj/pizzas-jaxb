package com.javaxpert.katas.pizzas.jaxb;

import io.vavr.control.Try;
import jakarta.xml.bind.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class MarshallUnmarshallPizza {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("Queen", 9.0f, Size.STANDARD);
        Pizza pizza2 = new Pizza("Regina", 7.0f, Size.STANDARD);
        Pizza pizza3 = new Pizza("Queen", 5.0f, Size.BAMBINO);
        List<Pizza> pizzasList = new ArrayList<>(5);

        pizzasList.add(pizza1);
        pizzasList.add(pizza2);
        pizzasList.add(pizza3);

        Order order = new Order();
        order.setPizzaList(pizzasList);
        String xmlString = null;

        Try<JAXBContext> contextTry = Try.of(() -> JAXBContext.newInstance(Order.class));
        Try<Marshaller> marshallerTry = Try.of(() -> contextTry.get().createMarshaller());
        StringWriter writer = new StringWriter();
        xmlString = marshallerTry
                .flatMap(marshaller -> Try.of(() -> {
                    marshaller.marshal(order, writer);
                    return writer.toString();
                }))
                .onFailure(throwable -> {
                    System.out.println("Unable to marshall to XML ");
                })
                .getOrElse("Error")
        ;


        System.out.println(xmlString);

        /**
         Unmarshaller unmarshaller = context.createUnmarshaller();
         Order orderFromXml = (Order) unmarshaller.unmarshal(new InputSource(new StringReader(xmlString)));
         boolean orderIsTheSaae = orderFromXml.equals(order);
         System.out.println("Order is the same after Unmarshalling :" + orderIsTheSaae);

         */
    }
}
