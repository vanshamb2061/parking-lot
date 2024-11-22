package ParkingStrategy;

import ParkingSpot.ParkingSpot;
import Vehicle.Vehicle;

import java.util.List;
import java.util.Map;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(Map<ParkingSpot, Vehicle> parkedList);
    ParkingSpot chooseParkingSpot(List<ParkingSpot> availableSpots);
}
