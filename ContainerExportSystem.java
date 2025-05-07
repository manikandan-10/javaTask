package com.ebrain.oopsproject;

import java.util.*;
import java.time.LocalDateTime;

public class ContainerExportSystem {

    interface Exporting {
        void shipping();
        void beginning();
        void complete();
    }

    static class AbstractContainer implements Exporting {
        private int id;
        private String type;
        private String trackingNumber;
        private LocalDateTime exportTime;
        private LocalDateTime deliveryTime;
        private String depot;
        private String destination;
        private Long containervalue;
        private String contents;
        private String usage;
        private String currentLocation;
        private String midLocation;

        public AbstractContainer(int id, String type, String depot, String destination,
                                 Long containervalue, String contents, String usage,
                                 String currentLocation, String midLocation) {
            this.id = id;
            this.type = type;
            this.depot = depot;
            this.destination = destination;
            this.containervalue = containervalue;
            this.contents = contents;
            this.usage = usage;
            this.currentLocation = currentLocation;
            this.midLocation = midLocation;
        }

        public void displayTask() {
            System.out.println("------ Container Details ------");
            System.out.println("ID: " + id);
            System.out.println("Type: " + type);
            System.out.println("Depot: " + depot);
            System.out.println("Destination: " + destination);
            System.out.println("Contents: " + contents);
            System.out.println("Container Value: " + containervalue);
            System.out.println("Tracking Number: " + trackingNumber);
            System.out.println("Usage: " + usage);
            System.out.println("Current Location: " + currentLocation);
            System.out.println("MidLocation:" + midLocation);
            System.out.println("-----------------------------");
        }

        @Override
        public void shipping() {
            System.out.println("Export started from: " + depot);
            exportTime = LocalDateTime.now();
        }

        @Override
        public void beginning() {
            if (currentLocation.equalsIgnoreCase(depot)) {
                currentLocation = midLocation;
                System.out.println("Container is now at the mid location: " + currentLocation);
            } else {
                System.out.println("Container is not at the depot. Can't move to mid location.");
            }
        }

        @Override
        public void complete() {
        	
            if (currentLocation.equalsIgnoreCase(midLocation)) {
                currentLocation = destination;
                deliveryTime = LocalDateTime.now();
                System.out.print("now container move to: " + midLocation + "  to  " + destination);
                System.out.println();
                System.out.println("Export completed!");
                System.out.println("Export Time: " + exportTime);
                System.out.println("Delivery Time: " + deliveryTime);
            } else {
                System.out.println("Container is not at the mid location. Can't move to destination.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<AbstractContainer> containers = new ArrayList<>();
       
        for(int i=1;i<4;i++) {

        System.out.println("\n--- Enter details for Container ---");

        System.out.print("Enter Container ID (int): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Container Type: ");
        String type = scanner.nextLine();

        System.out.print("Enter Depot Location: ");
        String depot = scanner.nextLine();

        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter Container Value (long): ");
        Long containervalue = scanner.nextLong();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Contents: ");
        String contents = scanner.nextLine();

        System.out.print("Enter Usage: ");
        String usage = scanner.nextLine();

        System.out.print("Enter Mid Location: ");
        String midLocation = scanner.nextLine();

        System.out.print("Enter Current Location: ");
        String currentLocation = scanner.nextLine();

        System.out.println("--------------------------------------------");

        AbstractContainer container = new AbstractContainer(
                id, type, depot, destination,
                containervalue, contents, usage,
                currentLocation, midLocation
        );

        containers.add(container);
        
        }
        scanner.close();

        for (AbstractContainer cont : containers) {
            cont.displayTask();
            cont.shipping();
            cont.beginning();
            cont.complete();
        }
    }
}

