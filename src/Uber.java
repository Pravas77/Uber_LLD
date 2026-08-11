import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Uber {
    private DriverManager driverManager;
    private RiderManager riderManager;
    private PricingStrategy pricingStrategy;
    private List<Trip> trips;

    public Uber(DriverManager driverManager, RiderManager riderManager, PricingStrategy pricingStrategy) {
        this.driverManager = driverManager;
        this.riderManager = riderManager;
        this.pricingStrategy = pricingStrategy;
        this.trips = new CopyOnWriteArrayList<>();
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public Trip bookTrip(Rider rider, Location from, Location to, VehicleType vehicleType){
        Driver driver = driverManager.searchDriver(rider.getCity(),from,vehicleType);
        double price = pricingStrategy.calculatePrice(from, to, vehicleType);

        Trip trip = new Trip(driver, rider, price, from, to);
        trips.add(trip);
        return trip;
    }
}
