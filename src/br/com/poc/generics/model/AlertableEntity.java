package br.com.poc.generics.model;

import java.util.UUID;

public class AlertableEntity<T extends AuditableModel> implements Alertable<T>{
    private T entity;

    public AlertableEntity(T entity) {
        this.entity = entity;
    }

    @Override
    public T getEntity() {
        return this.entity;
    }

    @Override
    public UUID getEntityId() {
        return this.entity.getId();
    }

    @Override
    public String getEntityName() {
        return this.getEntity().getClass().getTypeName().replace(this.getClass().getPackageName(), "").replace(".","");
    }
}
