import Admin.EntryGate;
import Admin.ParkingSpotManager;
import ParkingSpot.ParkingSpot;
import ParkingSpot.FourWheelerParkingSpot;
import ParkingSpot.TwoWheelerParkingSpot;
import ParkingStrategy.FIFOParkingStrategy;
import ParkingStrategy.LIFOParkingStrategy;
import Vehicle.FourWheeler;
import Vehicle.TwoWheeler;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        System.out.println("WELCOME TO THE PARKING LOT!");
        // SETUP
        //DECLARE PARKINGMGR, ADD SPOTS, ASSIGN PARKING STRATEGY
        ParkingSpotManager parkingSpotManager = ParkingSpotManager.getInstance();
        FourWheelerParkingSpot spot1 = new FourWheelerParkingSpot();
        FourWheelerParkingSpot spot2 = new FourWheelerParkingSpot();
        TwoWheelerParkingSpot spot3 = new TwoWheelerParkingSpot();
        TwoWheelerParkingSpot spot4 = new TwoWheelerParkingSpot();
        parkingSpotManager.parkingSpots.add(spot1);
        parkingSpotManager.parkingSpots.add(spot2);
        parkingSpotManager.parkingSpots.add(spot3);
        parkingSpotManager.parkingSpots.add(spot4);
        parkingSpotManager.parkedList.put(spot1,null);
        parkingSpotManager.parkedList.put(spot2,null);
        parkingSpotManager.parkedList.put(spot3,null);
        parkingSpotManager.parkedList.put(spot4,null);
        FourWheeler v1 = new FourWheeler(1111);
        FourWheeler v2 = new FourWheeler(1112);
        TwoWheeler v3 = new TwoWheeler(2222);
        EntryGate entryGate = EntryGate.getInstance();
        entryGate.parkingSpotManager = parkingSpotManager;
        parkingSpotManager.parkingStrategy = new FIFOParkingStrategy();

        //CREATE ENTRY GATE, CREATE VEHICLE

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to Proceed with parking");
        System.out.println("Press 0 to EXIT");
        // Read a line of text from the user
        Integer choice = scanner.nextInt();
        if(choice==0)
            exit(0);
        if(choice!=1)
            exit(-1);

        System.out.println("Entry Gate");
        System.out.println("Checking if entry is allowed!");
        System.out.println("Entry Allowed: " + entryGate.permitEntry(v1));

        System.out.println("Press 2 to park another vehicle");
        System.out.println("Press 0 to exit");
        choice = scanner.nextInt();
        if(choice==0)
            exit(0);
        if(choice!=2)
            exit(-1);
        System.out.println("Checking if entry is allowed!");
        parkingSpotManager.parkingStrategy=new LIFOParkingStrategy();
        System.out.println("Entry Allowed: " + entryGate.permitEntry(v2));

    }
}