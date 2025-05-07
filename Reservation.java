package com.ebrain.exception;

import java.util.Scanner;

class TrainTicket {
    String trainName;
    String source;
    String destination;
    String passengerName;
    int seatNumber;
    int fare;

    public TrainTicket(String trainName, String source, String destination, String passengerName, int seatNumber, int fare) {
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.fare = fare;
    }

    public void bookTicket(String name) {
    
            if (passengerName == null || passengerName.isEmpty()) {
                passengerName = name;
                System.out.println(name + " booked a ticket on " + trainName + " from " + source + " to " + destination);
            } else {
                System.out.println("Seat already booked by " + passengerName);
            }
   
    }

    public void cancelTicket() {
        
            if (passengerName != null && !passengerName.isEmpty()) {
                System.out.println(passengerName + "'s ticket has been cancelled.");
                passengerName = null;
            } else {
                System.out.println("No booking found to cancel.");
            }
    }

    public void updateFare(int newFare) {
        if (newFare > 0) {
            fare = newFare;
            System.out.println("Fare updated to Rs. " + fare);
        } else {
            System.out.println("Fare must be a positive number.");
        }
    }

    public void changeDestination(String newDestination) {
        if (newDestination == null || newDestination.isEmpty()) {
            System.out.println("Destination cannot be empty.");
        } else if (newDestination.matches(".*\\d.*")) {
            System.out.println("Destination cannot contain numbers.");
        } else {
            destination = newDestination;
            System.out.println("Destination updated to: " + destination);
        }
    }
}


public class Reservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {

        System.out.println("Enter train details:");
        System.out.print("Train Name: ");
        String trainName = scanner.nextLine();
        System.out.print("Source Station: ");
        String source = scanner.nextLine();
        System.out.print("Destination Station: ");
        String destination = scanner.nextLine();
        System.out.print("Initial Passenger Name (Leave empty if none): ");
        String passengerName = scanner.nextLine();
        System.out.print("Seat Number: ");
        int seatNumber = scanner.nextInt();
        System.out.print("Fare: ");
        int fare = scanner.nextInt();
        scanner.nextLine();

        TrainTicket ticket = new TrainTicket(trainName, source, destination, passengerName, seatNumber, fare);

        int choice;
        do {
            System.out.println("\n-------- Menu --------");
            System.out.println("1. Display Ticket Details");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Check Seat Availability");
            System.out.println("5. Update Fare");
            System.out.println("6. Change Destination");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                	try {
                    System.out.println("----- Ticket Details -----");
                    System.out.println("Train: " + ticket.trainName);
                    System.out.println("Source: " + ticket.source);
                    System.out.println("Destination: " + ticket.destination);
                    System.out.println("Seat Number: " + ticket.seatNumber);
                    System.out.println("Passenger: " + (ticket.passengerName != null && !ticket.passengerName.isEmpty() ? ticket.passengerName : "Not Booked"));
                    System.out.println("Fare: Rs. " + ticket.fare);
                	} catch(Exception e) {
                		System.out.print("Something went wrong");
                	}
                    break;

                case 2:
                	
                    System.out.print("Enter your name: ");
                    
                    try {
                    String name = scanner.nextLine();
                    ticket.bookTicket(name);
                    }
                    
                    catch(Exception e) {
                    	
                    	System.out.println(" invalid imputs please check");
                    }
                    break;

                case 3:
                	try {
                    ticket.cancelTicket();
                	} catch(Exception e) {
                		
                		System.out.println("gone wrong");
                	}
                    break;

                case 4:
                	System.out.print("Enter passenger name: ");

                	try {
                	    if (ticket.passengerName == null || ticket.passengerName.isEmpty()) {
                	        System.out.println("Seat is available.");
                	    } else {
                	        System.out.println("Seat is booked by " + ticket.passengerName);
                	    }
                	} catch (Exception e) {
                	    System.out.println("Invalid input.");
                	}
                	break;


                case 5:
                    System.out.print("Enter new fare: ");
                    try {
                        int newFare = scanner.nextInt();
                        ticket.updateFare(newFare);
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                        scanner.nextLine();
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Enter new destination: ");
                        String newDestination = scanner.nextLine();

                        if (newDestination == null || newDestination.isEmpty()) {
                            System.out.println("Error occurred in destination change.");
                        } else {
                            ticket.changeDestination(newDestination);
                        }
                    } catch (ArithmeticException e) {
                        System.out.println("Something went wrong during destination change.");
                    }
                    break;

                case 7:
                	try 
                	{
                    System.out.println("Thank you for using the Railway Reservation System.");
                	}catch(Exception e) {
                		
                		System.out.print("Ivalid input please choose given one");
                	}
                	break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 7);
        
        

        scanner.close();
    }
    catch (Exception e) {
    	System.out.print("program Succeed");
    }
    }
    
}
