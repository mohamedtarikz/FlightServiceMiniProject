package airline;

import java.util.Scanner;
public class AdminInputSystem extends InputSystem{
    public void onAddFlight(Scanner scanner) {
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
        FlightSystem.addFlight(From, To, date, time, seats, price);
        System.out.println("Flight added successfully!");
        ////////////////////////////////////////////////
    }

    public void onRemoveFlight(Scanner scanner) {
        OutputSystem.printFlights();
        System.out.print("Enter the FlightID to remove: ");
        String flightID = takeFlightIDInput(scanner);
        if (flightID != null && FlightSystem.removeFlight(flightID)) {
            System.out.println("Flight removed successfully!");
        }
        else{
            System.out.println("FlightID not found!");
        }
    }

    public void onModifyFlight(Scanner scanner) {
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
        try{
            ModificationOptions mod = ModificationOptions.valueOf(choice);
            switch (mod) {
                case A:
                    System.out.println("Enter the new departure date in the form 'DD.MM.YYYY': ");
                    String date = takeDateInput(scanner);
                    if (date == null) {
                        System.out.println("INVALID INPUT! Format should be 'DD.MM.YYYY'!");
                        return;
                    }
                    FlightSystem.modifyFlight(flightID, mod, date);
                    break;
                case B:
                    System.out.println("Enter the new departure time in the form 'HH:MM' (24-hour format): ");
                    String time = takeTimeInput(scanner);
                    if (time == null) {
                        System.out.println("INVALID INPUT! Format should be 'HH:MM'!");
                        return;
                    }
                    FlightSystem.modifyFlight(flightID, mod, time);
                    break;
                case C:
                    System.out.println("Enter the new number of seats: ");
                    int seats = takeSeatsInput(scanner);
                    if (seats == -1) {
                        System.out.println("INVALID INPUT! Seats should be a valid integer!");
                        return;
                    }
                    FlightSystem.modifyFlight(flightID, mod, Integer.toString(seats));
                    break;
                case D:
                    System.out.println("Enter the new price per seat: ");
                    double price = takePriceInput(scanner);
                    if (price == -1) {
                        System.out.println("INVALID INPUT! Price should be a valid decimal number!");
                        return;
                    }
                    FlightSystem.modifyFlight(flightID, mod, Double.toString(price));
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
