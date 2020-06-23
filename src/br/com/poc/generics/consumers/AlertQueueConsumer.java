package br.com.poc.generics.consumers;

import br.com.poc.generics.model.Alert;
import br.com.poc.generics.model.AlertFarmGroup;
import br.com.poc.generics.model.Alertable;
import br.com.poc.generics.model.AlertableEntity;
import br.com.poc.generics.producers.AlertEntityQueueProducer;

import java.util.List;
import java.util.UUID;

public class AlertQueueConsumer {

    AlertEntityQueueProducer alertEntityQueueProducer;

    public AlertQueueConsumer(AlertEntityQueueProducer alertEntityQueueProducer) {
        this.alertEntityQueueProducer = alertEntityQueueProducer;
    }

    // Rabbit Listener for Alert Process Queue
    public <T> void processAlertQueue(UUID alertFarmGroupId, List<Alertable<T>> alertableEntities, String entityRouteName, String entityQueueName){

        alertableEntities.forEach(alertableEntity->{
            this.alertEntityQueueProducer.sendAlertEntityToProcessQueue(alertFarmGroupId, alertableEntity, entityRouteName, entityQueueName);
        });
    }
}
