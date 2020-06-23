package br.com.poc.generics.consumers.handlers;

import br.com.poc.generics.model.AlertFarmGroup;
import br.com.poc.generics.model.Alertable;
import br.com.poc.generics.model.AlertableEntity;
import br.com.poc.generics.model.Lot;
import br.com.poc.generics.services.AlertFarmGroupService;

import java.util.UUID;

public class LotAlertHandler {

    AlertFarmGroupService alertFarmGroupService;

    public LotAlertHandler(AlertFarmGroupService alertFarmGroupService) {
        this.alertFarmGroupService = alertFarmGroupService;
    }

    // Rabbit Listener for Animal GDP
    public void verifyLotPicket(UUID alertFarmGroupId, Alertable<Lot> alertable){
        final Lot lot = alertable.getEntity();

        final AlertFarmGroup alertFarmGroup = alertFarmGroupService.findById(alertFarmGroupId);

        System.out.println(String.format("Processado alerta %s para o %s %s com os parametros %s", alertFarmGroup.getAlertId(), alertable.getEntityName(), lot.getName(), alertFarmGroup.getParameters()));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("");
    }
}
