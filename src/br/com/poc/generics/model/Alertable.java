package br.com.poc.generics.model;

import java.util.UUID;

public interface Alertable<T> {
    T getEntity();
    UUID getEntityId();
    String getEntityName();
}
