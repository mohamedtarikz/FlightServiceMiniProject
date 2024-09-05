package airline;

import java.util.Scanner;

public class PassengerInputSystem extends InputSystem{
    public void onBookFlight(Passenger passenger, Scanner scanner){
        System.out.println("A- Domestic flights\nB- International flights\nAnything else to CANCEL");
        String flightType = scanner.nextLine().toUpperCase();
        try {
            PassengerFlightType flightTypeValue = PassengerFlightType.valueOf(flightType);
            switch (flightTypeValue) {
                case A:
                    OutputSystem.printFlights(FlightType.DOMESTIC);
                    System.out.print("Enter the flightID of the flight you want to book: ");
                    String domID = takeFlightIDInput(scanner);
                    if (domID == null) {
                        System.out.println("Invalid input!!");
                        return;
                    }
                    if(!OutputSystem.printFlight(domID)){
                        System.out.println("Flight not found!!");
                        return;
                    }
                    System.out.print("Enter number of tickets to book: ");
                    int domTickets = takeSeatsInput(scanner);
                    if (domTickets < 1) {
                        System.out.println("Invalid input!!");
                        return;
                    }
                    FlightSystem.bookFlight(passenger, FlightType.DOMESTIC,domID,domTickets);
                case B:
                    OutputSystem.printFlights(FlightType.INTERNATIONAL);
                    System.out.print("Enter the flightID of the flight you want to book: ");
                    String intID = takeFlightIDInput(scanner);
                    if (intID == null) {
                        System.out.println("Invalid input!!");
                        return;
                    }
                    if(!OutputSystem.printFlight(intID)){
                        System.out.println("Flight not found!!");
                        return;
                    }
                    System.out.print("Enter number of tickets to book: ");
                    int intTickets = takeSeatsInput(scanner);
                    if (intTickets < 1) {
                        System.out.println("Invalid input!!");
                        return;
                    }
                    FlightSystem.bookFlight(passenger, FlightType.INTERNATIONAL,intID,intTickets);
            }
        } catch (IllegalArgumentException e) {
            return;
        }
    }
    public void onCancelFlight(Passenger passenger, Scanner scanner){
        if(!OutputSystem.printFlights(passenger)){
            return;
        }
        System.out.println("Enter the flightID of the flight you want to cancel: ");
        String id = takeFlightIDInput(scanner);
        if (id == null) {
            System.out.println("Invalid input!!");
            return;
        }
        if (passenger.getFlightTickets(FlightSystem.getFlight(id)) == 0){
            System.out.println("You have no tickets to cancel!!");
            return;
        }
        System.out.println("Enter number of tickets to cancel: ");
        int tickets = takeSeatsInput(scanner);
        if (tickets < 1) {
            System.out.println("Invalid input!!");
            return;
        }
        FlightSystem.cancelFlight(passenger, id, passenger.getFlightTickets(FlightSystem.getFlight(id)), tickets);
    }
}
