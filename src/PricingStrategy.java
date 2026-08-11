public interface PricingStrategy {
    Double calculatePrice(Location from, Location to, VehicleType vehicleType);
}
