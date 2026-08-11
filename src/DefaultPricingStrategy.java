public class DefaultPricingStrategy implements PricingStrategy{
    @Override
    public Double calculatePrice(Location from, Location to, VehicleType vehicleType) {
        return 250.0;
    }
}
