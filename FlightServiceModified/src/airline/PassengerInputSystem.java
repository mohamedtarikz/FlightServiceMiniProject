package airline;

import java.util.Scanner;

public class PassengerInputSystem extends InputSystem {

    // Handles the process of booking a flight for a passenger
    public void onBookFlight(Cart cart, Scanner scanner) {
        // Prompt the user to choose between domestic and international flights
        System.out.println("A- Domestic flights\nB- International flights\nAnything else to CANCEL");
        String flightType = scanner.nextLine().toUpperCase();

        try {
            // Convert user input to PassengerFlightType enum
            PassengerFlightType flightTypeValue = PassengerFlightType.valueOf(flightType);

            switch (flightTypeValue) {
                case A:
                    // Display domestic flights and prompt user for flightID
                    OutputSystem.printFlights(FlightType.DOMESTIC);
                    System.out.print("Enter the flightID of the flight you want to book: ");
                    String domID = takeFlightIDInput(scanner);

                    if (domID == null) {
                        System.out.println("Invalid input!!");
                        return;
                    }

                    // Check if the flight exists and prompt for the number of tickets
                    if (!OutputSystem.printFlight(domID)) {
                        System.out.println("Flight not found!!");
                        return;
                    }

                    System.out.print("Enter number of tickets to book: ");
                    int domTickets = takeSeatsInput(scanner);

                    if (domTickets < 1) {
                        System.out.println("Invalid input!!");
                        return;
                    }

                    // Book the flight for the passenger
                    FlightSystem.bookFlight(cart, FlightType.DOMESTIC, domID, domTickets);
                    break; // Added break to avoid fall-through

                case B:
                    // Display international flights and prompt user for flightID
                    OutputSystem.printFlights(FlightType.INTERNATIONAL);
                    System.out.print("Enter the flightID of the flight you want to book: ");
                    String intID = takeFlightIDInput(scanner);

                    if (intID == null) {
                        System.out.println("Invalid input!!");
                        return;
                    }

                    // Check if the flight exists and prompt for the number of tickets
                    if (!OutputSystem.printFlight(intID)) {
                        System.out.println("Flight not found!!");
                        return;
                    }

                    System.out.print("Enter number of tickets to book: ");
                    int intTickets = takeSeatsInput(scanner);

                    if (intTickets < 1) {
                        System.out.println("Invalid input!!");
                        return;
                    }

                    // Book the flight for the passenger
                    FlightSystem.bookFlight(cart, FlightType.INTERNATIONAL, intID, intTickets);
                    break; // Added break to avoid fall-through

            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid flight type selected!!");
        }
    }

    // Handles the process of canceling a flight booking for a passenger
    public void onCancelFlight(Cart cart, Scanner scanner) {
        // Display the passenger's booked flights
        if (!OutputSystem.printFlights(cart)) {
            return;
        }

        // Prompt the user for the flightID they want to cancel
        System.out.println("Enter the flightID of the flight you want to cancel: ");
        String id = takeFlightIDInput(scanner);

        if (id == null) {
            System.out.println("Invalid input!!");
            return;
        }

        // Check if the passenger has tickets for the specified flight
        if (cart.getFlightTickets(FlightSystem.getFlight(id)) == 0) {
            System.out.println("You have no tickets to cancel!!");
            return;
        }

        // Prompt the user for the number of tickets they want to cancel
        System.out.println("Enter number of tickets to cancel: ");
        int tickets = takeSeatsInput(scanner);

        if (tickets < 1) {
            System.out.println("Invalid input!!");
            return;
        }

        // Cancel the specified number of tickets for the flight
        FlightSystem.cancelFlight(cart, id, cart.getFlightTickets(FlightSystem.getFlight(id)), tickets);
    }
}
