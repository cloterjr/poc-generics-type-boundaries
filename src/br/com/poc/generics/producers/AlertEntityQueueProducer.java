package br.com.poc.generics.producers;

import br.com.poc.generics.consumers.handlers.AnimalAlertHandler;
import br.com.poc.generics.consumers.handlers.LotAlertHandler;
import br.com.poc.generics.model.Alertable;
import br.com.poc.generics.model.AlertableEntity;
import br.com.poc.generics.model.Animal;
import br.com.poc.generics.model.AuditableModel;

import java.util.UUID;

public class AlertEntityQueueProducer {

    AnimalAlertHandler animalAlertHandler;
    LotAlertHandler lotAlertHandler;

    public AlertEntityQueueProducer(AnimalAlertHandler animalAlertHandler, LotAlertHandler lotAlertHandler) {
        this.animalAlertHandler = animalAlertHandler;
        this.lotAlertHandler = lotAlertHandler;
    }

    public void sendAlertEntityToProcessQueue(UUID alertFarmGroupId, Alertable alertable, String entityRouteName, String entityQueueName) {

        // call rabbit to put the information bellow in the queue for every entity
        System.out.println(String.format("Inserido alerta %s na fila para a entidade %s na rota %s e fila %s", alertFarmGroupId, alertable.getEntity(), entityRouteName, entityQueueName));

        // Simulando o processamento da fila de entidades
        if(alertable.getEntityName().equalsIgnoreCase("animal")){
            this.animalAlertHandler.verifyAnimalGDPBellow(alertFarmGroupId, alertable);
        } else {
            this.lotAlertHandler.verifyLotPicket(alertFarmGroupId, alertable);
        }
    }
}
