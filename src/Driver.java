public class Driver {
    private int id;
    private boolean isAvailable;
    private VehicleType vehicleType;
    private City city;
    private Location location;

    public Driver(int id, boolean isAvailable, VehicleType vehicleType, City city, Location location) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.vehicleType = vehicleType;
        this.city = city;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
