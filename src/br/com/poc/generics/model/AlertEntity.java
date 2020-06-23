package br.com.poc.generics.model;

import java.util.Date;
import java.util.UUID;

public class AlertEntity extends AuditableModel {
    private UUID alertFarmGroupId;
    private UUID entityId;
    private String entityName;
    private Date silentUntilDate;
    private Boolean active;

    public AlertEntity(UUID id, UUID alertFarmGroupId, UUID entityId, String entityName, Date silentUntilDate, Boolean active) {
        super(id);
        this.alertFarmGroupId = alertFarmGroupId;
        this.entityId = entityId;
        this.entityName = entityName;
        this.silentUntilDate = silentUntilDate;
        this.active = active;
    }

    public UUID getAlertFarmGroupId() {
        return alertFarmGroupId;
    }

    public void setAlertFarmGroupId(UUID alertFarmGroupId) {
        this.alertFarmGroupId = alertFarmGroupId;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Date getSilentUntilDate() {
        return silentUntilDate;
    }

    public void setSilentUntilDate(Date silentUntilDate) {
        this.silentUntilDate = silentUntilDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
