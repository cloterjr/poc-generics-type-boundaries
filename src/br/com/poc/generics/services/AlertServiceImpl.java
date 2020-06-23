package br.com.poc.generics.services;

import br.com.poc.generics.model.Alert;
import br.com.poc.generics.model.AlertEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AlertServiceImpl implements AlertService {

    @Override
    public List<Alert> findAll() {
        final List<Alert> alerts = new ArrayList<>();
        alerts.add(new Alert(UUID.fromString("df1014e8-e1ee-4594-88a9-734a9126f9dd"), "GDP Abaixo da estrategia de dieta", "GDP Abaixo da estrategia de dieta", AlertEnum.ANIMAL_GDP_BELLOW));
        alerts.add(new Alert(UUID.fromString("5cccda20-8cf6-4afc-ba7e-7133774f538f"), "Animal sem pesagem por um longo período", "Animal sem pesagem por um longo período", AlertEnum.ANIMAL_WITHOUT_WEIGHT_UNTIL));
        alerts.add(new Alert(UUID.fromString("b79dd46d-74c9-48d3-b917-6e7d9bd73815"), "Lote sem piquete", "Lote sem piquete", AlertEnum.LOT_WITH_PICKET_NOT_REGISTERED));
        alerts.add(new Alert(UUID.fromString("8994983b-6c35-43e9-84fb-2468a27f2b0c"), "Dieta de estrategia sem periodo", "Dieta de estrategia sem periodo", AlertEnum.DIET_STRATEGIE_OUT_OF_PERIOD));

        return alerts;
    }
}
