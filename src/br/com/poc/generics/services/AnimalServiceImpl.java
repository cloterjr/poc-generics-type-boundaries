package br.com.poc.generics.services;

import br.com.poc.generics.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AnimalServiceImpl implements AnimalService {
    @Override
    public List<Animal> findAll() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(UUID.randomUUID(), "Animal 1", 5D));
        animals.add(new Animal(UUID.randomUUID(), "Animal 2", 10D));
        animals.add(new Animal(UUID.randomUUID(), "Animal 3", 3D));

        return animals;
    }
}
