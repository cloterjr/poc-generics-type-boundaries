package br.com.poc.generics.services;

import br.com.poc.generics.model.*;
import br.com.poc.generics.producers.AlertQueueProducer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AlertOrchestratorServiceImpl implements AlertOrchestratorService {

    AlertService alertService;

    AlertFarmGroupService alertFarmGroupService;

    AlertQueueProducer alertQueueProducer;

    public AlertOrchestratorServiceImpl(AlertService alertService, AlertFarmGroupService alertFarmGroupService, AlertQueueProducer alertQueueProducer) {
        this.alertService = alertService;
        this.alertFarmGroupService = alertFarmGroupService;
        this.alertQueueProducer = alertQueueProducer;
    }

    @Override
    public <T> void startVerification(UUID farmId, List<AlertEnum> alerts, List<Alertable<T>> alertableEntities) {
        // recuperar alertas
        final List<Alert> allAlerts = alertService.findAll();

        // recuperar alertas para a fazenda
        final List<AlertFarmGroup> farmAlerts = alertFarmGroupService.findAllByFarmIdAndAlertType(farmId, alerts);

        farmAlerts.stream().forEach(alertFarmGroup -> {
            final Optional<Alert> currentAlert = allAlerts.stream().filter(alert -> alert.getId().equals(alertFarmGroup.getAlertId())).findFirst();

            if(currentAlert.isPresent()) {
                final String routeName = currentAlert.get().getType().getRouteName();
                final String queueName = currentAlert.get().getType().getQueueName();
                final String entityRouteName = currentAlert.get().getType().getEntityRouteName();
                final String entityQueueName = currentAlert.get().getType().getEntityQueueName();

                this.alertQueueProducer.sendAlertToProcessQueue(alertFarmGroup.getId(), alertableEntities, routeName, queueName, entityRouteName, entityQueueName);
            }
        });
    }
}
