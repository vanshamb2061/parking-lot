package ParkingSpot;

import Vehicle.Vehicle;
import Receipt.Receipt;
public abstract class ParkingSpot {
    public static int ctr=1;
    protected int spotID;
    protected boolean isOccupied;
    protected Receipt receipt;

    public ParkingSpot() {
        this.spotID = ctr++;
        this.isOccupied = false;
        this.receipt = null;
    }

    public void occupySpot(Vehicle vehicle, Receipt receipt) {
            this.isOccupied = true;
            this.receipt = receipt;
            System.out.println("Vehicle: " + vehicle.getVehicleNumber() + " parked at " + this.spotID + " at time: " + receipt.getStartTime());
    }
}


