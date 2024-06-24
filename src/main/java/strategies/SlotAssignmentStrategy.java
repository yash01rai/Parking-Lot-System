package strategies;

import models.ParkingLot;
import models.Slot;
import models.VehicleType;

public interface SlotAssignmentStrategy {
    public Slot getSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
