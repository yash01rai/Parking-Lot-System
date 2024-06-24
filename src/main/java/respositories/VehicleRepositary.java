package respositories;

import models.Vehicle;

import java.util.Optional;

public class VehicleRepositary {

    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber) {
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        // certain actions to save the object

        return vehicle; // now you'll have the id in the vehicle object
    }

}
