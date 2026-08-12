import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello");

        Driver driver1 = new Driver(1, true, VehicleType.BIKE, City.DELHI, new Location(1, 0));
        Driver driver2 = new Driver(2, true, VehicleType.BIKE, City.MUMBAI, new Location(0, 1));

        Map<City, List<Driver>> driverMap = new ConcurrentHashMap<>();
        driverMap.computeIfAbsent(City.DELHI, k -> new CopyOnWriteArrayList<>()).add(driver1);
        driverMap.computeIfAbsent(City.MUMBAI, k -> new CopyOnWriteArrayList<>()).add(driver2);

        Map<City, ReentrantLock> reentrantLockMap = new ConcurrentHashMap<>();
        reentrantLockMap.computeIfAbsent(City.DELHI, k -> new ReentrantLock());
        reentrantLockMap.computeIfAbsent(City.MUMBAI, k -> new ReentrantLock());

        DriverManager driverManager = new DriverManager(driverMap, reentrantLockMap, new NearestDriverSearchStrategy());


        Rider rider1 = new Rider(1, City.DELHI);
        Rider rider2 = new Rider(2, City.DELHI);
        Rider rider3 = new Rider(3, City.MUMBAI);

        Map<City, List<Rider>> riderMap = new ConcurrentHashMap<>();
        riderMap.computeIfAbsent(City.DELHI, k -> new CopyOnWriteArrayList<>()).add(rider1);
        riderMap.computeIfAbsent(City.DELHI, k -> new CopyOnWriteArrayList<>()).add(rider2);
        riderMap.computeIfAbsent(City.MUMBAI, k -> new CopyOnWriteArrayList<>()).add(rider3);

        RiderManager riderManager = new RiderManager(riderMap);


        Uber uber = new Uber(driverManager, riderManager, new DistanceBasedPricingStrategy());






        //client
        Thread thread1 = new Thread(() -> {
            Trip trip = uber.bookTrip(rider1, new Location(0, 0), new Location(3, 4), VehicleType.BIKE);

            System.out.println(trip);
        });


        Thread thread2 = new Thread(() -> {
            Trip trip = uber.bookTrip(rider3, new Location(0, 0), new Location(6, 8), VehicleType.BIKE);

            System.out.println(trip);
        });


        thread1.start();
        thread2.start();



    }
}