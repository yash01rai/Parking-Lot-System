package models;

import java.util.List;

public class Floor extends BaseModel {

    private String floorNumber;

    private List<Slot> parkingSlots;

    private FloorStatus floorStatus;

    private List<VehicleType> vehicleTypes;


    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<Slot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<Slot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public FloorStatus getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(FloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
