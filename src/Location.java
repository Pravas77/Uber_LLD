public class Location {
    private double longitude;
    private double latitude;

    public Location(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public double calculateDistance(Location nextLocation){
        double distance = Math.sqrt(
                (nextLocation.getLongitude()-longitude) * (nextLocation.getLongitude()-longitude)
                + (nextLocation.getLatitude()-latitude) * (nextLocation.getLatitude()-latitude)
        );

        return distance;
    }
}
