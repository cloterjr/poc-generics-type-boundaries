package br.com.poc.generics.consumers.handlers;

import br.com.poc.generics.model.*;
import br.com.poc.generics.services.AlertFarmGroupService;

import java.util.UUID;

public class AnimalAlertHandler {

    AlertFarmGroupService alertFarmGroupService;

    public AnimalAlertHandler(AlertFarmGroupService alertFarmGroupService) {
        this.alertFarmGroupService = alertFarmGroupService;
    }

    // Rabbit Listener for Animal GDP
    public void verifyAnimalGDPBellow(UUID alertFarmGroupId, Alertable<Animal> alertableEntity){
        final Animal animal = alertableEntity.getEntity();

        final AlertFarmGroup alertFarmGroup = alertFarmGroupService.findById(alertFarmGroupId);

        System.out.println(String.format("Processado alerta %s para o %s %s com os parametros %s", alertFarmGroup.getAlertId(), alertableEntity.getEntityName(), animal.getName(), alertFarmGroup.getParameters()));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("");
    }
}
