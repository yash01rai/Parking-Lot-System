import Controllers.TokenController;
import models.ParkingLot;
import respositories.GateRepository;
import respositories.ParkingLotRepository;
import respositories.TokenRepositary;
import respositories.VehicleRepositary;
import services.TokenService;

public class Client {
    public static void main(String[] args) {
        // we need objects of
        // controllers needs -> services -> respositories
        // topological sort?

        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TokenRepositary tokenRepositary = new TokenRepositary();
        VehicleRepositary vehicleRepositary = new VehicleRepositary();

        TokenService tokenService = new TokenService(
                gateRepository,
                vehicleRepositary,
                parkingLotRepository,
                tokenRepositary
        );

        TokenController tokenController = new TokenController(tokenService);

//      now calling part you need to perform

//      hard code the data
//        ParkingLot parkingLot = new ParkingLot();

    }
}


