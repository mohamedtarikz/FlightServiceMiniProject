package airline;

import java.util.Scanner;
import java.util.regex.*;

public class InputSystem {
    // Methods to handle admin addition of a new flight
    protected Location takeLocationInput(Scanner scanner) {
        String location = scanner.nextLine();
        if (!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+", location)) {
            System.out.println("Invalid Input! Format should be 'City, Country'!!");
            return null;
        }
        String city = location.split(",")[0];
        String country = location.split(",")[1];
        return new Location(city, country);
    }
    protected String takeTimeInput(Scanner scanner) {
        String time = scanner.nextLine();
        if (!Pattern.matches("([0-1][0-9]|2[0-3])\\:([0-5][0-9])", time)) {
            System.out.println("Invalid Input! Format should be 'HH:MM'!!");
            return null;
        }
        return time;
    }
    protected String takeDateInput(Scanner scanner) {
        String date = scanner.nextLine();
        if (!Pattern.matches("(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(20(2[4-9]|[3-9][0-9]))", date)) {
            System.out.println("Invalid Input! Format should be 'DD/MM/YYYY'!!");
            return null;
        }
        return date;
    }
    protected int takeSeatsInput(Scanner scanner) {
        String seats = scanner.nextLine();
        if (!Pattern.matches("[0-9]+", seats)) {
            System.out.println("Invalid Input! Seats should be a valid integer!!");
            return -1;
        }
        int ret_seats = Integer.parseInt(seats);
        if (ret_seats <= 0)
            return -1;
        else
            return ret_seats;

    }
    protected double takePriceInput(Scanner scanner) {
        String price = scanner.nextLine();
        if (!Pattern.matches("\\d+(\\.(0[1-9]|[1-9][0-9]))?", price)) {
            System.out.println("Invalid Input! Price should be a valid decimal number!!");
            return -1;
        }
        double ret_price = Double.parseDouble(price);
        if (ret_price <= 0)
            return -1;
        else
            return ret_price;
    }
    protected String takeFlightIDInput(Scanner scanner) {
        String flightID = scanner.nextLine().toUpperCase();
        if (!Pattern.matches("[ID]\\d+", flightID)) {
            System.out.println("Invalid Input! No Such ID!!");
            return null;
        }
        return flightID;
    }
}
