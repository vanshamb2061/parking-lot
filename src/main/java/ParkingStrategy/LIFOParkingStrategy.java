package ParkingStrategy;

import Vehicle.Vehicle;
import ParkingSpot.ParkingSpot;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LIFOParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(Map<ParkingSpot, Vehicle> parkedList) {
        List<ParkingSpot> availableSpots = parkedList.entrySet().stream()
                .filter(entry -> entry.getValue() == null) // Filter entries where the vehicle is null
                .map(Map.Entry::getKey) // Map to ParkingSpot keys
                .toList();
        return this.chooseParkingSpot(availableSpots);
    }

    @Override
    public ParkingSpot chooseParkingSpot(List<ParkingSpot> availableSpots){
        return availableSpots.isEmpty() ? null : availableSpots.get(0);
    }
}
