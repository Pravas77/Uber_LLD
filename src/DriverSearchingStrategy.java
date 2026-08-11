import java.util.List;

public interface DriverSearchingStrategy {
    public Driver searchDriver(List<Driver> drivers,Location from, VehicleType vehicleType);
}
