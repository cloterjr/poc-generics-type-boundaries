package br.com.poc.generics.model;

import java.util.List;
import java.util.UUID;

public class AlertFarmGroup extends AuditableModel {
    private UUID alertId;
    private UUID farmId;
    private UUID groupId;
    private boolean grouped;
    private Integer minimumItemsToGroup;
    private List<Parameter> parameters;

    public AlertFarmGroup(UUID id, UUID alertId, UUID farmId, UUID groupId, Boolean grouped, Integer minimumItemsToGroup, List<Parameter> parameters) {
        super(id);
        this.alertId = alertId;
        this.farmId = farmId;
        this.groupId = groupId;
        this.grouped = grouped;
        this.minimumItemsToGroup = minimumItemsToGroup;
        this.parameters = parameters;
    }

    public UUID getAlertId() {
        return alertId;
    }

    public void setAlertId(UUID alertId) {
        this.alertId = alertId;
    }

    public UUID getFarmId() {
        return farmId;
    }

    public void setFarmId(UUID farmId) {
        this.farmId = farmId;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public boolean isGrouped() {
        return grouped;
    }

    public void setGrouped(boolean grouped) {
        this.grouped = grouped;
    }

    public Integer getMinimumItemsToGroup() {
        return minimumItemsToGroup;
    }

    public void setMinimumItemsToGroup(Integer minimumItemsToGroup) {
        this.minimumItemsToGroup = minimumItemsToGroup;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "AlertFarmGroup{" +
                "alertId=" + alertId +
                ", farmId=" + farmId +
                ", groupId=" + groupId +
                ", grouped=" + grouped +
                ", minimumItemsToGroup=" + minimumItemsToGroup +
                ", parameters=" + parameters +
                '}';
    }
}
