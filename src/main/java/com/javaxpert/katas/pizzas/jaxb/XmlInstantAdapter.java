package com.javaxpert.katas.pizzas.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.Instant;

public class XmlInstantAdapter extends XmlAdapter<String, Instant> {
    @Override
    public Instant unmarshal(String s) throws Exception {
        return Instant.ofEpochMilli(Long.parseLong(s));
    }

    @Override
    public String marshal(Instant instant) throws Exception {
        return ""+ instant.toEpochMilli();
    }
}
