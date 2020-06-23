package br.com.poc.generics.services;

import br.com.poc.generics.model.AlertEnum;
import br.com.poc.generics.model.Alertable;
import br.com.poc.generics.model.AuditableModel;

import java.util.List;
import java.util.UUID;

public interface AlertOrchestratorService {
    <T> void startVerification(UUID farmId, List<AlertEnum> alerts, List<Alertable<T>> entities);
}
