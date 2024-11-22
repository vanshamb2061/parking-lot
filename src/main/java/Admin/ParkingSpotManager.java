package Admin;

import ParkingSpot.ParkingSpot;
import ParkingStrategy.ParkingStrategy;
import Receipt.Receipt;
import Vehicle.Vehicle;

import java.util.*;

//singleton
public class ParkingSpotManager {
    public ParkingStrategy parkingStrategy;
    public Map<ParkingSpot, Vehicle> parkedList;
    public List<ParkingSpot> parkingSpots;
    private static ParkingSpotManager instance;

    public static ParkingSpotManager getInstance(){
        if(Objects.isNull(instance)){
            instance = new ParkingSpotManager();
        }
        return instance;
    }

    private ParkingSpotManager() {
        // Initialize your fields here if necessary
        parkedList = new HashMap<>();
        parkingSpots = new ArrayList<>();
    }

    boolean parkVehicle(Vehicle vehicle, Receipt receipt){
        ParkingSpot parkingSpot = this.findParkingSpot();
        if(Objects.isNull(parkingSpot))
            return false;
        parkingSpot.occupySpot(vehicle,receipt);
        parkedList.put(parkingSpot,vehicle);
        return true;
    }

    boolean isAvailable(){
        // implement logic to iterate through map and see if spots are available
        System.out.println("Yes, spots are available!");
        return true;
    }

    ParkingSpot findParkingSpot(){
        return parkingStrategy.findParkingSpot(parkedList);
    }

    boolean unparkVehicle(Vehicle vehicle, ParkingSpot parkingSpot){
        return true;
    }

}
