package Admin;

import Receipt.Receipt;
import Vehicle.Vehicle;

import java.util.Objects;

public class EntryGate {
    public ParkingSpotManager parkingSpotManager;
    private static EntryGate instance;
    public static EntryGate getInstance(){
        if(Objects.isNull(instance)){
            instance = new EntryGate();
        }
        return instance;
    }

    public boolean permitEntry(Vehicle vehicle){
        if(!this.checkAvailability())
            return false;
        Receipt receipt = this.generateReceipt(vehicle);
        System.out.println("Receipt generated: " + receipt.getStartTime() + " for vehicle: " + receipt.getVehicle().getVehicleNumber());
        boolean parkingDone = parkingSpotManager.parkVehicle(vehicle,receipt);
        return parkingDone;
    }

    public boolean checkAvailability(){
        return parkingSpotManager.isAvailable();
    }

    Receipt generateReceipt(Vehicle vehicle){
        return new Receipt(vehicle);
    }
}
