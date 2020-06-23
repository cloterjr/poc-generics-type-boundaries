package br.com.poc.generics.services;

import br.com.poc.generics.model.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> findAll();
}
