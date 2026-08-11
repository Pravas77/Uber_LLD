public class Rider {
    private int id;
    private City city;

    public Rider(int id, City city) {
        this.id = id;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
