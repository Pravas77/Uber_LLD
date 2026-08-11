public class DistanceBasedPricingStrategy implements PricingStrategy{
    @Override
    public Double calculatePrice(Location from, Location to, VehicleType vehicleType) {
        double distance = from.calculateDistance(to);
        return 20.0 + distance * vehicleType.getPerKmPrice();
    }
}
