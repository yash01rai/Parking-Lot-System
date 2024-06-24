package strategies;

import models.*;
import respositories.ParkingLotRepository;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy{

    @Override
    public Slot getSlot(ParkingLot parkingLot, VehicleType vehicleType) {

//        ParkingLot parkingLot = parkingLotRepository.findParkingLotByGate(gate);

        for(Floor floor: parkingLot.getFloors()){
            for(Slot slot: floor.getParkingSlots()){
                if(slot.getSupportedVehicleType().contains(vehicleType) &&
                    slot.getSlotStatus().equals(SlotStatus.EMPTY)
                ) {
                    return slot;
                }
            }
        }
        return null;
    }
}
