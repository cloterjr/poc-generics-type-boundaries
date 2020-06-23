package br.com.poc.generics.services;

import br.com.poc.generics.model.AlertEnum;
import br.com.poc.generics.model.AlertFarmGroup;

import java.util.List;
import java.util.UUID;

public interface AlertFarmGroupService {
    List<AlertFarmGroup> findAllByFarmIdAndAlertType(UUID farmId, List<AlertEnum> alertTypes);

    AlertFarmGroup findById(UUID alertFarmGroupId);
}
