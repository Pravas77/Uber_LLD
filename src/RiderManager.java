import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class RiderManager {
    private Map<City, List<Rider>> riderMap;

    public RiderManager(Map<City, List<Rider>> riderMap) {
        this.riderMap = riderMap;
    }

    public void addRider(Rider rider){
        riderMap.computeIfAbsent(rider.getCity(), k-> new CopyOnWriteArrayList<>()).add(rider);
    }
}
