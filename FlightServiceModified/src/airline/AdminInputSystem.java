package airline;

import java.util.Scanner;
import java.util.regex.*;
public class AdminInputSystem implements AddFlightListener,RemoveFlightListener,ModifyFlightListener{
    // Methods to handle admin addition of a new flight
    private Location takeLocationInput(Scanner scanner) {
        String location = scanner.nextLine();
        if (!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+", location)) {
            System.out.println("Invalid Input! Format should be 'City, Country'!!");
            return null;
        }
        String city = location.split(",")[0];
        String country = location.split(",")[1];
        return new Location(city, country);
    }
    private String takeTimeInput(Scanner scanner) {
        String time = scanner.nextLine();
        if (!Pattern.matches("([0-1][0-9]|2[0-3])\\:([0-5][0-9])", time)) {
            System.out.println("Invalid Input! Format should be 'HH:MM'!!");
            return null;
        }
        return time;
    }
    private String takeDateInput(Scanner scanner) {
        String date = scanner.nextLine();
        if (!Pattern.matches("(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(20(2[4-9]|[3-9][0-9]))", date)) {
            System.out.println("Invalid Input! Format should be 'DD/MM/YYYY'!!");
            return null;
        }
        return date;
    }
    private int takeSeatsInput(Scanner scanner) {
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
    private double takePriceInput(Scanner scanner) {
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
    private String takeFlightIDInput(Scanner scanner) {
        String flightID = scanner.nextLine().toUpperCase();
        if (!Pattern.matches("[ID]\\d+", flightID)) {
            System.out.println("Invalid Input! No Such ID!!");
            return null;
        }
        return flightID;
    }
    @Override
    public void onAddFlight(AddFlightEvent e, Admin admin, Scanner scanner) {
        //Take the flight details from admin
        //Confirm the departure and destination//
        System.out.println("Enter the departure location in the form 'City, Country': ");
        Location From = takeLocationInput(scanner);
        if(From == null) {
            return;
        }
        System.out.println("Enter the destination in the form 'City, Country': ");
        Location To = takeLocationInput(scanner);
        if(To == null) {
            return;
        }
        ////////////////////////////////////////////////
        //Confirm the departure date and time//
        System.out.println("Enter the departure date in the form 'DD.MM.YYYY': ");
        String date = takeDateInput(scanner);
        if(date == null) {
            return;
        }
        System.out.println("Enter the departure time in the form 'HH:MM' (24-hour format): ");
        String time = takeTimeInput(scanner);
        if(time == null) {
            return;
        }
        ////////////////////////////////////////////////
        //Confirm the seats number and price//
        System.out.println("Enter the number of seats: ");
        int seats = takeSeatsInput(scanner);
        if(seats == -1) {
            return;
        }
        System.out.println("Enter the price per seat: ");
        double price = takePriceInput(scanner);
        if(price == -1) {
            return;
        }
        ////////////////////////////////////////////////
        //Create a new flight//
        admin.addFlight(From, To, date, time, seats, price);
        System.out.println("Flight added successfully!");
        ////////////////////////////////////////////////
    }

    @Override
    public void onRemoveFlight(RemoveFlightEvent event, Admin admin, Scanner scanner) {
        OutputSystem.printFlights();
        System.out.print("Enter the FlightID to remove: ");
        String flightID = takeFlightIDInput(scanner);
        if (flightID != null && admin.removeFlight(flightID)) {
            System.out.println("Flight removed successfully!");
        }
        else{
            System.out.println("FlightID not found!");
        }
    }

    @Override
    public void onModifyFlight(ModifyFlightEvent event, Admin admin, Scanner scanner) {
        OutputSystem.printFlights();
        System.out.println("Enter the FlightID to modify: ");
        String flightID = takeFlightIDInput(scanner);
        if(!OutputSystem.printFlight(flightID)){
            System.out.println("FlightID not found!");
            return;
        }
        System.out.println("Choose property to be modified: ");
        System.out.println("A- Date\nB- Time\nC- Seats\nD- Price\nAnything else to CANCEL!");
        String choice = scanner.nextLine().toUpperCase();
        ModificationOptions mod = ModificationOptions.valueOf(choice);
        try{
            switch (mod) {
                case A:
                    System.out.println("Enter the new departure date in the form 'DD.MM.YYYY': ");
                    String date = takeDateInput(scanner);
                    if (date == null) {
                        System.out.println("INVALID INPUT! Format should be 'DD.MM.YYYY'!");
                        return;
                    }
                    admin.modifyFlight(flightID, mod, date);
                    break;
                case B:
                    System.out.println("Enter the new departure time in the form 'HH:MM' (24-hour format): ");
                    String time = takeTimeInput(scanner);
                    if (time == null) {
                        System.out.println("INVALID INPUT! Format should be 'HH:MM'!");
                        return;
                    }
                    admin.modifyFlight(flightID, mod, time);
                    break;
                case C:
                    System.out.println("Enter the new number of seats: ");
                    int seats = takeSeatsInput(scanner);
                    if (seats == -1) {
                        System.out.println("INVALID INPUT! Seats should be a valid integer!");
                        return;
                    }
                    admin.modifyFlight(flightID, mod, Integer.toString(seats));
                    break;
                case D:
                    System.out.println("Enter the new price per seat: ");
                    double price = takePriceInput(scanner);
                    if (price == -1) {
                        System.out.println("INVALID INPUT! Price should be a valid decimal number!");
                        return;
                    }
                    admin.modifyFlight(flightID, mod, Double.toString(price));
                    break;
                default:
                    return;
            }
        }
        catch (IllegalArgumentException e){
            return;
        }
    }
}
