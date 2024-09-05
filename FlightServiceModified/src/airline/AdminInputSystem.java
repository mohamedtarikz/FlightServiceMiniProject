package airline;

import java.util.Scanner;

public class AdminInputSystem extends InputSystem {

    // Method to handle the process of adding a flight
    public void onAddFlight(Scanner scanner) {
        // Prompt for the departure location
        System.out.println("Enter the departure location in the form 'City, Country': ");
        Location From = takeLocationInput(scanner);  // Takes location input from the user
        if (From == null) {
            return;  // Exit if the input is invalid
        }

        // Prompt for the destination location
        System.out.println("Enter the destination in the form 'City, Country': ");
        Location To = takeLocationInput(scanner);  // Takes destination input from the user
        if (To == null) {
            return;  // Exit if the input is invalid
        }

        // Prompt for the departure date
        System.out.println("Enter the departure date in the form 'DD.MM.YYYY': ");
        String date = takeDateInput(scanner);  // Takes date input from the user
        if (date == null) {
            return;  // Exit if the input is invalid
        }

        // Prompt for the departure time
        System.out.println("Enter the departure time in the form 'HH:MM' (24-hour format): ");
        String time = takeTimeInput(scanner);  // Takes time input from the user
        if (time == null) {
            return;  // Exit if the input is invalid
        }

        // Prompt for the number of seats
        System.out.println("Enter the number of seats: ");
        int seats = takeSeatsInput(scanner);  // Takes seat count input from the user
        if (seats == -1) {
            return;  // Exit if the input is invalid
        }

        // Prompt for the price per seat
        System.out.println("Enter the price per seat: ");
        double price = takePriceInput(scanner);  // Takes price input from the user
        if (price == -1) {
            return;  // Exit if the input is invalid
        }

        // Create a new flight with the gathered information
        FlightSystem.addFlight(From, To, date, time, seats, price);
        System.out.println("Flight added successfully!");  // Confirm flight addition
    }

    // Method to handle the process of removing a flight
    public void onRemoveFlight(Scanner scanner) {
        OutputSystem.printFlights();  // Display all available flights
        System.out.print("Enter the FlightID to remove: ");
        String flightID = takeFlightIDInput(scanner);  // Takes FlightID input from the user

        // If the flight exists and is successfully removed, display success message
        if (flightID != null && FlightSystem.removeFlight(flightID)) {
            System.out.println("Flight removed successfully!");
        } else {
            System.out.println("FlightID not found!");  // If the flight doesn't exist, display error
        }
    }

    // Method to handle the process of modifying a flight
    public void onModifyFlight(Scanner scanner) {
        OutputSystem.printFlights();  // Display all available flights
        System.out.println("Enter the FlightID to modify: ");
        String flightID = takeFlightIDInput(scanner);  // Takes FlightID input from the user

        // Display the flight details and check if FlightID is valid
        if (!OutputSystem.printFlight(flightID)) {
            System.out.println("FlightID not found!");  // If the flight doesn't exist, display error
            return;
        }

        // Prompt the user to choose which property to modify
        System.out.println("Choose property to be modified: ");
        System.out.println("A- Date\nB- Time\nC- Seats\nD- Price\nAnything else to CANCEL!");
        String choice = scanner.nextLine().toUpperCase();  // Take user choice as input

        try {
            ModificationOptions mod = ModificationOptions.valueOf(choice);  // Map input to enum

            switch (mod) {
                case A:
                    // Modify the flight date
                    System.out.println("Enter the new departure date in the form 'DD.MM.YYYY': ");
                    String date = takeDateInput(scanner);  // Take new date input
                    if (date == null) {
                        System.out.println("INVALID INPUT! Format should be 'DD.MM.YYYY'!");
                        return;
                    }
                    FlightSystem.modifyFlight(flightID, mod, date);  // Modify the flight date
                    break;
                case B:
                    // Modify the flight time
                    System.out.println("Enter the new departure time in the form 'HH:MM' (24-hour format): ");
                    String time = takeTimeInput(scanner);  // Take new time input
                    if (time == null) {
                        System.out.println("INVALID INPUT! Format should be 'HH:MM'!");
                        return;
                    }
                    FlightSystem.modifyFlight(flightID, mod, time);  // Modify the flight time
                    break;
                case C:
                    // Modify the number of seats
                    System.out.println("Enter the new number of seats: ");
                    int seats = takeSeatsInput(scanner);  // Take new seat count input
                    if (seats == -1) {
                        System.out.println("INVALID INPUT! Seats should be a valid integer!");
                        return;
                    }
                    FlightSystem.modifyFlight(flightID, mod, Integer.toString(seats));  // Modify the seat count
                    break;
                case D:
                    // Modify the price per seat
                    System.out.println("Enter the new price per seat: ");
                    double price = takePriceInput(scanner);  // Take new price input
                    if (price == -1) {
                        System.out.println("INVALID INPUT! Price should be a valid decimal number!");
                        return;
                    }
                    FlightSystem.modifyFlight(flightID, mod, Double.toString(price));  // Modify the price
                    break;
                default:
                    return;  // Exit if input is not valid
            }
        } catch (IllegalArgumentException e) {
            return;  // Handle invalid input gracefully
        }
    }
}
