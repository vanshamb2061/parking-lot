package Receipt;

import Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Receipt {
    private Vehicle vehicle;
    private LocalDateTime startTime;

    public Receipt(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.startTime = LocalDateTime.now();
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}