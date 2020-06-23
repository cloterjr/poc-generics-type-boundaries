package br.com.poc.generics.model;

import java.util.List;
import java.util.UUID;

public class Parameter {
    private UUID id;
    private String code;
    private List<ParameterItem> items;

    public Parameter(UUID id, String code, List<ParameterItem> items) {
        this.id = id;
        this.code = code;
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ParameterItem> getItems() {
        return items;
    }

    public void setItems(List<ParameterItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", items=" + items +
                '}';
    }
}
