package airline;

import java.util.List;

public class OutputSystem {
    // Method to print all domestic and international flights
    public static void printFlights(){
        // Print header for domestic flights
        System.out.println("====================Domestic flights====================");
        // Loop through all domestic flights and print their details
        for (Flight flight: FlightSystem.getFlights(FlightType.DOMESTIC)){
            System.out.print(flight);
        }
        // Print header for international flights
        System.out.println("====================International flights====================");
        // Loop through all international flights and print their details
        for (Flight flight: FlightSystem.getFlights(FlightType.INTERNATIONAL)){
            System.out.print(flight);
        }
    }

    // Method to print flights of a specific type (domestic or international)
    public static void printFlights(FlightType type){
        if(type == FlightType.DOMESTIC) {
            // If flight type is domestic, print domestic flights
            System.out.println("====================Domestic flights====================");
            for (Flight flight: FlightSystem.getFlights(FlightType.DOMESTIC)){
                System.out.print(flight);
            }
        }
        else if(type == FlightType.INTERNATIONAL) {
            // If flight type is international, print international flights
            System.out.println("====================International flights====================");
            for (Flight flight: FlightSystem.getFlights(FlightType.INTERNATIONAL)){
                System.out.print(flight);
            }
        }
    }

    // Method to print the flights booked by a specific passenger
    public static boolean printFlights(Cart cart){
        // Get the list of flights the passenger has booked
        List<Flight> flights = cart.getFlights();
        // If there are flights, print them
        if (!flights.isEmpty()) {
            System.out.println("====================Your Flights====================");
            // Loop through each flight and print its details
            for (Flight flight : flights) {
                System.out.println("-----------------------------------------------");
                System.out.println("ID: " + flight.getId());
                System.out.println("Take off: " + flight.getFrom().getCity() + ", " + flight.getFrom().getCountry());
                System.out.println("Destination: " + flight.getTo().getCity() + ", " + flight.getTo().getCountry());
                System.out.println("Date: " + flight.getDate());
                System.out.println("Time: " + flight.getTime());
                System.out.println("Tickets Booked: " + cart.getFlightTickets(flight));
                System.out.println("Price: " + flight.getPrice());
                System.out.println("------------------------------------------------");
            }
            return true; // Return true if there are flights
        }
        else{
            // If no flights are booked, notify the user
            System.out.println("You have no flights");
            return false; // Return false if no flights
        }
    }

    // Method to print details of a specific flight by flight ID
    public static boolean printFlight(String flightID){
        // Get the flight from the flight system using the ID
        Flight flight = FlightSystem.getFlight(flightID);
        if (flight != null){
            // If the flight is found, print its details
            System.out.println(flight);
            return true; // Return true if flight found
        }
        return false; // Return false if flight not found
    }

    // Method to print available options based on user type (Admin or Passenger)
    public static void viewOptions(UserType userType){
        if(userType == UserType.ADMIN) {
            // Print options for Admin users
            System.out.println("\nA- Add Flight\nB- Delete Flight\nC- Modify Flight\nD- List Flights\nE- EXIT");
            System.out.print("Please enter your choice: ");
        } else if (userType == UserType.PASSENGER) {
            // Print options for Passenger users
            System.out.println("\nA- Book Tickets\nB- Cancel Bookings\nC- View Bookings\nD- EXIT");
            System.out.print("Please enter your choice: ");
        }
    }
}
