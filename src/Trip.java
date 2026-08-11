public class Trip {
    public Driver driver;
    public Rider rider;
    public double price;
    public TripStatus tripStatus;
    public Location from;
    public Location to;

    @Override
    public String toString() {
        return "Trip{" +
                "driver=" + driver +
                ", rider=" + rider +
                ", price=" + price +
                ", tripStatus=" + tripStatus +
                ", from=" + from +
                ", to=" + to +
                '}';
    }

    public Trip(Driver driver, Rider rider, double price, Location from, Location to) {
        this.driver = driver;
        this.rider = rider;
        this.price = price;
        this.tripStatus = TripStatus.ACCEPTED;
        this.from = from;
        this.to = to;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }
}
