package models;

import java.sql.Date;

public class Token extends BaseModel {

    private String tokenNumber;
    private Date entryTime;
    private Gate generatedAt;
    private Operator generatedBy;
    private Vehicle vehicle;
    private Slot assignedSlot;

    public String getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Slot getAssignedSlot() {
        return assignedSlot;
    }

    public void setAssignedSlot(Slot assignedSlot) {
        this.assignedSlot = assignedSlot;
    }
}
