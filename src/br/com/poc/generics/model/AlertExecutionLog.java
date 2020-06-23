package br.com.poc.generics.model;

import java.util.Date;
import java.util.UUID;

public class AlertExecutionLog {
    private UUID id;
    private UUID alertFarmGroupId;
    private Date createdAt;
    private Date updatedAt;
    private Integer totalToExecute;
    private Integer totalExecutedWithSuccess;
    private Integer totalExecutedWithError;
    private AlertExecutionStatusEnum status;
    private String message;

    public AlertExecutionLog(UUID id, UUID alertFarmGroupId, Integer totalToExecute, Integer totalExecutedWithSuccess, Integer totalExecutedWithError, AlertExecutionStatusEnum status, String message) {
        this.id = id;
        this.alertFarmGroupId = alertFarmGroupId;
        this.createdAt = new Date();
        this.totalToExecute = totalToExecute;
        this.totalExecutedWithSuccess = totalExecutedWithSuccess;
        this.totalExecutedWithError = totalExecutedWithError;
        this.status = status;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAlertFarmGroupId() {
        return alertFarmGroupId;
    }

    public void setAlertFarmGroupId(UUID alertFarmGroupId) {
        this.alertFarmGroupId = alertFarmGroupId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getTotalToExecute() {
        return totalToExecute;
    }

    public void setTotalToExecute(Integer totalToExecute) {
        this.totalToExecute = totalToExecute;
    }

    public Integer getTotalExecutedWithSuccess() {
        return totalExecutedWithSuccess;
    }

    public void setTotalExecutedWithSuccess(Integer totalExecutedWithSuccess) {
        this.totalExecutedWithSuccess = totalExecutedWithSuccess;
    }

    public Integer getTotalExecutedWithError() {
        return totalExecutedWithError;
    }

    public void setTotalExecutedWithError(Integer totalExecutedWithError) {
        this.totalExecutedWithError = totalExecutedWithError;
    }

    public AlertExecutionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AlertExecutionStatusEnum status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
