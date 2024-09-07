package airline;

import java.util.Scanner;
import java.util.regex.*;

public abstract class InputSystem {
    // Method to take and validate input for a Location (City, Country)
    // It expects input in the format 'City, Country' (e.g., 'Cairo, Egypt').
    protected Location takeLocationInput(Scanner scanner) {
        String location = scanner.nextLine();
        // Check if the input matches the pattern 'City, Country' with proper spacing
        if (!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+", location)) {
            System.out.println("Invalid Input! Format should be 'City, Country'!!");
            return null; // Return null if the input is invalid
        }
        // Split the input string by ',' to get city and country
        String city = location.split(",")[0];
        String country = location.split(",")[1];
        // Return a new Location object with the parsed city and country
        return new Location(city, country);
    }

    // Method to take and validate input for flight time
    // It expects input in the format 'HH:MM' (e.g., '08:30').
    protected String takeTimeInput(Scanner scanner) {
        String time = scanner.nextLine();
        // Check if the time input matches the 24-hour format 'HH:MM'
        if (!Pattern.matches("([0-1][0-9]|2[0-3])\\:([0-5][0-9])", time)) {
            System.out.println("Invalid Input! Format should be 'HH:MM'!!");
            return null; // Return null if the input is invalid
        }
        return time; // Return the valid time input
    }

    // Method to take and validate input for the flight date
    // It expects input in the format 'DD.MM.YYYY' (e.g., '25.08.2024').
    protected String takeDateInput(Scanner scanner) {
        String date = scanner.nextLine();
        // Check if the date input matches the format 'DD.MM.YYYY' for valid days, months, and years
        if (!Pattern.matches("(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(20(2[4-9]|[3-9][0-9]))", date)) {
            System.out.println("Invalid Input! Format should be 'DD/MM/YYYY'!!");
            return null; // Return null if the input is invalid
        }
        return date; // Return the valid date input
    }

    // Method to take and validate input for the number of seats
    // It expects input to be a positive integer.
    protected int takeSeatsInput(Scanner scanner) {
        String seats = scanner.nextLine();
        // Check if the seats input is a valid integer
        if (!Pattern.matches("[0-9]+", seats)) {
            System.out.println("Invalid Input! Seats should be a valid integer!!");
            return -1; // Return -1 if the input is invalid
        }
        int ret_seats = Integer.parseInt(seats);
        // Ensure the seat count is greater than 0
        if (ret_seats <= 0)
            return -1;
        else
            return ret_seats; // Return the valid number of seats
    }

    // Method to take and validate input for the flight price
    // It expects input to be a valid decimal number (e.g., 99.99).
    protected double takePriceInput(Scanner scanner) {
        String price = scanner.nextLine();
        // Check if the price input matches a valid decimal number format
        if (!Pattern.matches("\\d+(\\.(0[1-9]|[1-9][0-9]))?", price)) {
            System.out.println("Invalid Input! Price should be a valid decimal number!!");
            return -1; // Return -1 if the input is invalid
        }
        double ret_price = Double.parseDouble(price);
        // Ensure the price is greater than 0
        if (ret_price <= 0)
            return -1;
        else
            return ret_price; // Return the valid price
    }

    // Method to take and validate input for the flight ID
    // It expects input in the format starting with 'I' or 'D' followed by digits (e.g., 'D123').
    protected String takeFlightIDInput(Scanner scanner) {
        String flightID = scanner.nextLine().toUpperCase();
        // Check if the flight ID matches the format starting with 'I' or 'D' followed by digits
        if (!Pattern.matches("[ID]\\d+", flightID)) {
            System.out.println("Invalid Input! No Such ID!!");
            return null; // Return null if the input is invalid
        }
        return flightID; // Return the valid flight ID
    }
}
