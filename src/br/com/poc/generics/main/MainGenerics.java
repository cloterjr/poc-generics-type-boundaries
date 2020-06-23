package br.com.poc.generics.main;

import br.com.poc.generics.consumers.AlertQueueConsumer;
import br.com.poc.generics.consumers.handlers.AnimalAlertHandler;
import br.com.poc.generics.consumers.handlers.LotAlertHandler;
import br.com.poc.generics.model.*;
import br.com.poc.generics.producers.AlertEntityQueueProducer;
import br.com.poc.generics.producers.AlertQueueProducer;
import br.com.poc.generics.services.AlertFarmGroupServiceImpl;
import br.com.poc.generics.services.AlertOrchestratorServiceImpl;
import br.com.poc.generics.services.AlertServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainGenerics {
    public static void main(String[] args) {

        final AlertServiceImpl alertService = new AlertServiceImpl();
        final AlertFarmGroupServiceImpl alertFarmGroupService = new AlertFarmGroupServiceImpl(alertService);

        final AnimalAlertHandler animalAlertHandler = new AnimalAlertHandler(alertFarmGroupService);
        final LotAlertHandler lotAlertHandler = new LotAlertHandler(alertFarmGroupService);

        final AlertEntityQueueProducer alertEntityQueueProducer = new AlertEntityQueueProducer(animalAlertHandler, lotAlertHandler);
        final AlertQueueConsumer alertQueueConsumer = new AlertQueueConsumer(alertEntityQueueProducer);
        final AlertQueueProducer alertQueueProducer = new AlertQueueProducer(alertQueueConsumer);

        final AlertOrchestratorServiceImpl alertOrchestratorService = new AlertOrchestratorServiceImpl(alertService, alertFarmGroupService, alertQueueProducer);

        // Animal Alerts
        List<AlertEnum> animalsAlerts = new ArrayList<>();

        animalsAlerts.add(AlertEnum.ANIMAL_GDP_BELLOW);
        animalsAlerts.add(AlertEnum.ANIMAL_WITHOUT_WEIGHT_UNTIL);

        Animal animal = new Animal(UUID.randomUUID(), "Animal 1", 5D);
        Alertable<Animal> alertableAnimal1 = new AlertableEntity<>(animal);
        Animal animal2 = new Animal(UUID.randomUUID(), "Animal 2", 4D);
        Alertable<Animal> alertableAnimal2 = new AlertableEntity<>(animal2);
        List<Alertable<Animal>> animals = new ArrayList<>();
        animals.add(alertableAnimal1);
        animals.add(alertableAnimal2);

        alertOrchestratorService.startVerification(UUID.fromString("669c6498-2c5a-48d0-bc19-e13a89fb8ca7"), animalsAlerts, animals);


        // Lot Alerts
        List<AlertEnum> lotAlerts = new ArrayList<>();

        lotAlerts.add(AlertEnum.LOT_WITH_PICKET_NOT_REGISTERED);

        Lot lot = new Lot(UUID.randomUUID(), "Lot 1", 4);
        Alertable<Lot> alertableLot = new AlertableEntity<>(lot);
        List<Alertable<Lot>> lots = new ArrayList<>();
        lots.add(alertableLot);

        alertOrchestratorService.startVerification(UUID.fromString("669c6498-2c5a-48d0-bc19-e13a89fb8ca7"), lotAlerts, lots);
    }
}
