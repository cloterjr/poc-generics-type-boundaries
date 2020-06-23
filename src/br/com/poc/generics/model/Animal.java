package br.com.poc.generics.model;

import java.util.UUID;

public class Animal extends AuditableModel {
    private String name;
    private Double gdp;

    public Animal(UUID id, String name, Double gdp) {
        super(id);
        this.name = name;
        this.gdp = gdp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }



    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", gdp=" + gdp +
                '}';
    }
}
