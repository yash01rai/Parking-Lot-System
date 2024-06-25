package services;

import models.*;
import respositories.GateRepository;
import respositories.ParkingLotRepository;
import respositories.TokenRepositary;
import respositories.VehicleRepositary;
import strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TokenService {

    private GateRepository gateRepository;
    private VehicleRepositary vehicleRepositary;
    private ParkingLotRepository parkingLotRepository;
    private TokenRepositary tokenRepositary;

    public TokenService(
            GateRepository gateRepository,
            VehicleRepositary vehicleRepositary,
            ParkingLotRepository parkingLotRepository,
            TokenRepositary tokenRepositary
    ) {
        this.gateRepository = gateRepository;
        this.vehicleRepositary = vehicleRepositary;
        this.parkingLotRepository = parkingLotRepository;
        this.tokenRepositary = tokenRepositary;
    }

    public Token issueToken(
            Long gateId,
            VehicleType vehicleType,
            String vehicleNumber,
            String ownerName
    ) {

        // 1. create a token
        // when store the token in the db id will be generated that is use to as the token number
        Token token = new Token();

        token.setEntryTime(new Date());

        // using the getId, we'll get the gate object from the database
        // Services don’t directly interact with databases but use repositories as the medium
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);

        // Optional is industry standard
        if(gateOptional.isEmpty()) {
            throw new RuntimeException("Invalid gate entered!");
        }

        Gate gate = gateOptional.get();
        token.setGeneratedAt(gate);
        token.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> vehicleOptional = vehicleRepositary.findVehicleByNumber(vehicleNumber);

        Vehicle savedVehicle;
        if (vehicleOptional.isEmpty()) {
            // since it is a new vehicle, we create it and save it in the db
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            savedVehicle = vehicleRepositary.save(vehicle);

        } else {
            savedVehicle = vehicleOptional.get();
        }

        token.setVehicle(savedVehicle);

        // 2. assign a slot
            // we can have different strategies to allocate the slot
        ParkingLot parkingLot = parkingLotRepository.findParkingLotByGate(gate);
        Slot slot = SlotAssignmentStrategyFactory
                .getSlotAssignmentStrategyByType(parkingLot.getSlotAssignmentStrategyType())
                .getSlot(parkingLot, vehicleType);

        token.setAssignedSlot(slot);
        slot.setSlotStatus(SlotStatus.FILLED);

        Token savedToken = tokenRepositary.save(token);
        savedToken.setTokenNumber(savedToken.getId() + "-TOKEN");

        return savedToken;
    }
}
