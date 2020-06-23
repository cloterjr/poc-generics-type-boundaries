package br.com.poc.generics.producers;

import br.com.poc.generics.consumers.AlertQueueConsumer;
import br.com.poc.generics.model.Alertable;
import br.com.poc.generics.model.AlertableEntity;
import br.com.poc.generics.model.AuditableModel;

import java.util.List;
import java.util.UUID;

public class AlertQueueProducer {

    AlertQueueConsumer alertQueueConsumer;

    public AlertQueueProducer(AlertQueueConsumer alertQueueConsumer) {
        this.alertQueueConsumer = alertQueueConsumer;
    }

    // Rabbit Producer
    public <T> void sendAlertToProcessQueue(UUID alertFarmGroupId, List<Alertable<T>> entities, String routeName, String queueName, String entityRouteName, String entityQueueName) {
        // Call rabbit to put the information bellow on a queue
        System.out.println(String.format("Processando alerta %s para as entidades %s na rota %s e fila %s", alertFarmGroupId, entities, routeName, queueName));
        System.out.println("");

        // Simulando o processamento da fila
        this.alertQueueConsumer.processAlertQueue(alertFarmGroupId, entities, entityRouteName, entityQueueName);
    }
}
