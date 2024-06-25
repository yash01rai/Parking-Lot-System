package respositories;

import models.Gate;
import models.ParkingLot;

import java.util.Map;
import java.util.TreeMap;

// no longer required as we stored the parking lot directly in the gate model
public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();

    public ParkingLot findParkingLotByGate(Gate gate){
        return null;
    }
}
