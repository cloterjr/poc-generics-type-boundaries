package br.com.poc.generics.model;

import java.util.Map;
import java.util.UUID;

public class ParameterItem {
    private UUID id;
    private UUID parameterId;
    private Map<String, String> values;

    public ParameterItem(UUID id, UUID parameterId, Map<String, String> values) {
        this.id = id;
        this.parameterId = parameterId;
        this.values = values;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getParameterId() {
        return parameterId;
    }

    public void setParameterId(UUID parameterId) {
        this.parameterId = parameterId;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "ParameterItem{" +
                "id=" + id +
                ", parameterId=" + parameterId +
                ", values=" + values +
                '}';
    }
}
