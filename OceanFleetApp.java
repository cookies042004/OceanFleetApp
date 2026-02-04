
/**
 * OceanFleetApp UC4 - Identify High-Performance Vessels.
 *
 * This Store multiple vessel records efficiently in memory.
 * And display vessel records efficiently.
 * The final outcome of this use case is, we will have HighPerformance Vessel.
 *
 * @Developer
 * @version4.0
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class VesselUtil {
    // Maintain List of Vessel objects
    private List<Vessel> vesselList;

    // Constructor
    public VesselUtil() {
        vesselList = new ArrayList<>();
    }

    // Add Vessel Performance
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
        System.out.println("Vessel added successfully!");
    }

    // Method to display all vessels
    public void displayAllVessels() {
        if (vesselList.isEmpty()) {
            System.out.println("No vessels available.");
            return;
        }

        for (Vessel vessel : vesselList) {
            System.out.println("----------------------------");
            System.out.println("ID: " + vessel.getVesselId());
            System.out.println("Name: " + vessel.getVesselName());
            System.out.println("Speed: " + vessel.getAverageSpeed());
            System.out.println("Type: " + vessel.getVesselType());
        }
    }

    // Method to retrieve by ID
     public Vessel getVesselByID(String id){
        for(Vessel vessel : vesselList){
            if(vessel.getVesselId().equalsIgnoreCase(id)){
                return vessel;
            }
        }

        return null;
     }

     // Get High Performance Vessels (Highest Speed)
     public List<Vessel> getHighPerformanceVessels() {

         List<Vessel> result = new ArrayList<>();

         if (vesselList.isEmpty()) {
             return result; // return empty list
         }

         // Step 1: Find maximum speed
         double maxSpeed = vesselList.get(0).getAverageSpeed();

         for (Vessel vessel : vesselList) {
             if (vessel.getAverageSpeed() > maxSpeed) {
                 maxSpeed = vessel.getAverageSpeed();
             }
         }

         // Step 2: Collect vessels having maxSpeed
         for (Vessel vessel : vesselList) {
             if (vessel.getAverageSpeed() == maxSpeed) {
                 result.add(vessel);
             }
         }

         return result;
     }
 }

class Vessel {
    // Instance Variables (Encapsulation: kept private)
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    // No-Argument Constructor
    public Vessel() {
    }

    // Parameterized Constructor
    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    // Getter Methods
    public String getVesselId() {
        return vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public String getVesselType() {
        return vesselType;
    }

    // Setter Methods
    public void setVesselId(String vesselId) {
        this.vesselId = vesselId;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }
}

public class OceanFleetApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.print("How many vessels do you want to add? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= count; i++) {
            System.out.println("\nEnter details for Vessel " + i);

            System.out.print("Vessel ID: ");
            String id = scanner.nextLine();

            System.out.print("Vessel Name: ");
            String name = scanner.nextLine();

            System.out.print("Average Speed: ");
            double speed = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Vessel Type: ");
            String type = scanner.nextLine();

            Vessel vessel = new Vessel(id, name, speed, type);

            vesselUtil.addVesselPerformance(vessel);
        }

        System.out.println("\nAll Stored Vessel Records:");
        vesselUtil.displayAllVessels();

        System.out.println("\nSearch Vessel By ID");
        System.out.print("Enter Vessel ID to search: ");
        String searchId = scanner.nextLine();

        Vessel foundVessel = vesselUtil.getVesselByID(searchId);

        if (foundVessel != null) {
            System.out.println("Vessel Found:");
            System.out.println("ID: " + foundVessel.getVesselId());
            System.out.println("Name: " + foundVessel.getVesselName());
            System.out.println("Speed: " + foundVessel.getAverageSpeed());
            System.out.println("Type: " + foundVessel.getVesselType());
        } else {
            System.out.println("Vessel not found with ID: " + searchId);
        }

        System.out.println("\nHigh Performance Vessel(s):");

        List<Vessel> highPerformanceList = vesselUtil.getHighPerformanceVessels();

        if (highPerformanceList.isEmpty()) {
            System.out.println("No vessels available.");
        } else {
            for (Vessel vessel : highPerformanceList) {
                System.out.println("----------------------------");
                System.out.println("ID: " + vessel.getVesselId());
                System.out.println("Name: " + vessel.getVesselName());
                System.out.println("Speed: " + vessel.getAverageSpeed());
                System.out.println("Type: " + vessel.getVesselType());
            }
        }

        scanner.close();
    }
}
