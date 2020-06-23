package br.com.poc.generics.model;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class AuditableModel {
    private UUID id;
    private Date createdAt;
    private Date deletedAt;
    private Date updatedAt;
    private Map<String, String> loadedValues;

    public AuditableModel(UUID id) {
        this.id = id;
        this.createdAt = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, String> getLoadedValues() {
        return loadedValues;
    }

    public void setLoadedValues(Map<String, String> loadedValues) {
        this.loadedValues = loadedValues;
    }
}
