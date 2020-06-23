package br.com.poc.generics.services;

import br.com.poc.generics.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class AlertFarmGroupServiceImpl implements AlertFarmGroupService {

    private AlertService alertService;

    public AlertFarmGroupServiceImpl(AlertService alertService) {
        this.alertService = alertService;
    }

    @Override
    public List<AlertFarmGroup> findAllByFarmIdAndAlertType(UUID farmId, List<AlertEnum> alertTypes) {
        // farm1:669c6498-2c5a-48d0-bc19-e13a89fb8ca7
        // group1: c9ac12fb-a958-491d-949f-238f5b0eefd7

        List<Alert> alerts =  alertService.findAll();

        List<AlertFarmGroup> farmAlerts = new ArrayList<>();

        // P1
        List<Parameter> parameters = new ArrayList<>();

        final Parameter p1 = new Parameter(UUID.randomUUID(), "P001", null);

        List<ParameterItem> items = new ArrayList<>();
        Map<String, String> values = new HashMap<>();
        values.put("GDP Goal Value", "100");
        items.add(new ParameterItem(UUID.randomUUID(), p1.getId(), values));
        p1.setItems(items);

        parameters.add(p1);
        // end P1

        // P2
        List<Parameter> parameter2 = new ArrayList<>();

        final Parameter p2 = new Parameter(UUID.randomUUID(), "P002", null);

        List<ParameterItem> items2 = new ArrayList<>();
        Map<String, String> values2 = new HashMap<>();
        values2.put("Days", "5");
        items2.add(new ParameterItem(UUID.randomUUID(), p2.getId(), values2));
        p2.setItems(items2);

        parameter2.add(p2);
        // end P1

        farmAlerts.add(new AlertFarmGroup(UUID.fromString("92534668-e606-4f44-8bc4-0b6b4128d7e4"), alerts.get(0).getId(), UUID.fromString("669c6498-2c5a-48d0-bc19-e13a89fb8ca7"), UUID.fromString("669c6498-2c5a-48d0-bc19-e13a89fb8ca7"), true, 2, parameters));
        farmAlerts.add(new AlertFarmGroup(UUID.fromString("65bb6913-4a7c-4920-b529-fb481bc466fd"), alerts.get(1).getId(), UUID.fromString("669c6498-2c5a-48d0-bc19-e13a89fb8ca7"), UUID.fromString("669c6498-2c5a-48d0-bc19-e13a89fb8ca7"), true, 3, parameter2));
        farmAlerts.add(new AlertFarmGroup(UUID.fromString("7f3b4c3c-525b-4b1b-aef7-fd871effd8b7"), alerts.get(2).getId(), UUID.fromString("669c6498-2c5a-48d0-bc19-e13a89fb8ca7"), UUID.fromString("669c6498-2c5a-48d0-bc19-e13a89fb8ca7"), true, 1, parameter2));

        if(alertTypes != null && alertTypes.size()>0) {
            List<Alert> filteredAlerts = alerts.stream().filter(alert->alertTypes.contains(alert.getType())).collect(Collectors.toList());
            return farmAlerts.stream().filter(farmAlert->filteredAlerts.stream().map(Alert::getId).collect(Collectors.toList()).contains(farmAlert.getAlertId())).collect(Collectors.toList());
        }

        return farmAlerts;
    }

    @Override
    public AlertFarmGroup findById(UUID alertFarmGroupId) {
        // Gambiarra
        final List<AlertFarmGroup> allAlerts = this.findAllByFarmIdAndAlertType(UUID.fromString("669c6498-2c5a-48d0-bc19-e13a89fb8ca7"), null);
        final Optional<AlertFarmGroup> first = allAlerts.stream().filter(alert -> alert.getId().equals(alertFarmGroupId)).findFirst();

        return first.get();
    }
}
