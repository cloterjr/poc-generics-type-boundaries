package br.com.poc.generics.model;

import java.util.UUID;

public class Alert extends AuditableModel {
    private String name;
    private String description;
    private AlertEnum type;

    public Alert(UUID id, String name, String description, AlertEnum type) {
        super(id);
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AlertEnum getType() {
        return type;
    }

    public void setType(AlertEnum type) {
        this.type = type;
    }
}
