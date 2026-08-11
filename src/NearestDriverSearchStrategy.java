import java.util.List;

public class NearestDriverSearchStrategy implements DriverSearchingStrategy {
    @Override
    public Driver searchDriver(List<Driver> drivers, Location from, VehicleType vehicleType) {

        Driver selectedDriver = null;
        double minDistance = Double.MAX_VALUE;
        for (Driver driver : drivers) {
            if (!driver.isAvailable() || driver.getVehicleType() != vehicleType) continue;
            double curDistance = from.calculateDistance(driver.getLocation());

            if (curDistance < minDistance) {
                minDistance = curDistance;
                selectedDriver = driver;
            }
        }


        if (selectedDriver == null) throw  new RuntimeException("Driver not found!");
        selectedDriver.setAvailable(false);
        return selectedDriver;
    }
}
