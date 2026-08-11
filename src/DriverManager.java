import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class DriverManager {
    private Map<City, List<Driver>> driverMap;
    private Map<City, ReentrantLock> reentrantLockMap;
    private DriverSearchingStrategy driverSearchingStrategy;

    public DriverManager(Map<City, List<Driver>> driverMap, Map<City, ReentrantLock> reentrantLockMap, DriverSearchingStrategy driverSearchingStrategy) {
        this.driverMap = driverMap;
        this.reentrantLockMap = reentrantLockMap;
        this.driverSearchingStrategy = driverSearchingStrategy;
    }

    public void addDriver(Driver driver){
        driverMap.computeIfAbsent(driver.getCity(), k-> new CopyOnWriteArrayList<>()).add(driver);
        reentrantLockMap.computeIfAbsent(driver.getCity(), k -> new ReentrantLock());
    }

    public Driver searchDriver(City city,Location from,VehicleType vehicleType){
        List<Driver> drivers = driverMap.getOrDefault(city,new ArrayList<>());
        ReentrantLock lock = reentrantLockMap.get(city);
        lock.lock();

        try {
        return driverSearchingStrategy.searchDriver(drivers,from,vehicleType);
        }finally {
            lock.unlock();
        }
    }


}
