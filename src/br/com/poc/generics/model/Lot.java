package br.com.poc.generics.model;

import java.util.UUID;

public class Lot extends AuditableModel {
    private String name;
    private Integer capacity;

    public Lot(UUID id, String name, Integer capacity) {
        super(id);
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
