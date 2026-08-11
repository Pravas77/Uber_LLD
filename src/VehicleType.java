public enum VehicleType {
    BIKE(10),AUTO(15),SEDAN(20);
    private int perKmPrice;

    private VehicleType(int perKmPrice) {
        this.perKmPrice = perKmPrice;
    }

    public int getPerKmPrice() {
        return perKmPrice;
    }

    public void setPerKmPrice(int perKmPrice) {
        this.perKmPrice = perKmPrice;
    }
}
