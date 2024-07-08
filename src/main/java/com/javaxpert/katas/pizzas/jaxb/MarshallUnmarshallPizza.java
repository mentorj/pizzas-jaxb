package com.javaxpert.katas.pizzas.jaxb;

import jakarta.xml.bind.*;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class MarshallUnmarshallPizza {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("Queen",9.0f,Size.STANDARD);
        Pizza pizza2 = new Pizza("Regina",7.0f,Size.STANDARD);
        Pizza pizza3 = new Pizza("Queen",5.0f,Size.BAMBINO);
        List<Pizza> pizzasList = new ArrayList<>(5);

        pizzasList.add(pizza1);
        pizzasList.add(pizza2);
        pizzasList.add(pizza3);

        Order order = new Order();
        order.setPizzaList(pizzasList);
        String xmlString = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Order.class);
            Marshaller  marshaller = context.createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.marshal(order,writer);
            xmlString=writer.toString();
            System.out.println(xmlString);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Order orderFromXml = (Order) unmarshaller.unmarshal(new InputSource(new StringReader(xmlString)));
            boolean orderIsTheSaae = orderFromXml.equals(order);
            System.out.println("Order is the same after Unmarshalling :" + orderIsTheSaae);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
