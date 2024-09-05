package airline;

import java.util.List;

public class OutputSystem {
    public static void printFlights(){
        System.out.println("====================Domestic flights====================");
        for (Flight flight: FlightSystem.getFlights(FlightType.DOMESTIC)){
            System.out.print(flight);
        }
        System.out.println("====================International flights====================");
        for (Flight flight: FlightSystem.getFlights(FlightType.INTERNATIONAL)){
            System.out.print(flight);
        }
    }
    public static void printFlights(FlightType type){
        if(type == FlightType.DOMESTIC) {
            System.out.println("====================Domestic flights====================");
            for (Flight flight: FlightSystem.getFlights(FlightType.DOMESTIC)){
                System.out.print(flight);
            }
        }
        else if(type == FlightType.INTERNATIONAL) {
            System.out.println("====================International flights====================");
            for (Flight flight: FlightSystem.getFlights(FlightType.INTERNATIONAL)){
                System.out.print(flight);
            }
        }
    }

    public static boolean printFlights(Passenger passenger){
        List<Flight> flights = passenger.getFlights();
        if (!flights.isEmpty()) {
            System.out.println("====================Your Flights====================");
            for (Flight flight : flights) {
                System.out.println("-----------------------------------------------");
                System.out.println("ID: " + flight.getId());
                System.out.println("Take off: " + flight.getFrom().getCity() + ", " + flight.getFrom().getCountry());
                System.out.println("Destination: " + flight.getTo().getCity() + ", " + flight.getTo().getCountry());
                System.out.println("Date: " + flight.getDate());
                System.out.println("Time: " + flight.getTime());
                System.out.println("Tickets Booked: " + passenger.getFlightTickets(flight));
                System.out.println("Price: " + flight.getPrice());
                System.out.println("------------------------------------------------");
            }
            return true;
        }
        else{
            System.out.println("You have no flights");
            return false;
        }
    }
    public static boolean printFlight(String flightID){
        Flight flight = FlightSystem.getFlight(flightID);
        if (flight != null){
            System.out.println(flight);
            return true;
        }
        return false;
    }

    public static void viewOptions(UserType userType){
        if(userType == UserType.ADMIN) {
            System.out.println("\nA- Add Flight\nB- Delete Flight\nC- Modify Flight\nD- List Flights\nE- EXIT");
            System.out.print("Please enter your choice: ");
        } else if (userType == UserType.PASSENGER) {
            System.out.println("\nA- Book Tickets\nB- Cancel Bookings\nC- View Bookings\nD- EXIT");
            System.out.print("Please enter your choice: ");
        }
    }
}
