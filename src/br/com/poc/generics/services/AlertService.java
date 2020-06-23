package br.com.poc.generics.services;

import br.com.poc.generics.model.Alert;

import java.util.List;
import java.util.UUID;

public interface AlertService {
    List<Alert> findAll();
}
