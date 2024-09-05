package airline;

import java.util.*;

public class Passenger extends SysUser implements BookFlightListener, CancelFlightListener {
    // A map to keep track of the number of tickets booked for each flight
    private Map<Flight, Integer> flightTickets = new HashMap<Flight, Integer>();
    // A list to keep track of the flights booked by the passenger
    private List<Flight> flights = new ArrayList<Flight>();

    // Instance of PassengerInputSystem to handle user input for booking and cancelling flights
    PassengerInputSystem passengerInputSystem = new PassengerInputSystem();

    // Constructor to initialize the Passenger object with a username, password, and user type
    public Passenger(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.PASSENGER);
    }

    // Method to get the list of flights booked by the passenger
    public List<Flight> getFlights() {
        return flights;
    }

    // Method to get the number of tickets booked for a specific flight
    public int getFlightTickets(Flight flight) {
        if (flight == null){
            return 0;
        }
        // Return the number of tickets for the flight if it exists in the map, otherwise return 0
        return flightTickets.getOrDefault(flight, 0);
    }

    // Method to add a flight and the number of tickets booked for that flight
    public void addFlight(Flight flight, int tickets) {
        // If the flight is already in the list, update the number of tickets
        if (flights.contains(flight)) {
            flightTickets.compute(flight, (k, v) -> (v + tickets));
        } else {
            // If the flight is not in the list, add it and put the number of tickets in the map
            flights.add(flight);
            flightTickets.put(flight, tickets);
        }
    }

    // Method to remove a flight or reduce the number of tickets for a flight
    public void removeFlight(Flight flight, int tickets) {
        // If the number of tickets after removal is greater than 0, update the number of tickets
        if (flightTickets.get(flight) - tickets > 0) {
            flightTickets.compute(flight, (k, v) -> (v - tickets));
        } else {
            // If no tickets are left, remove the flight from the list and map
            flights.remove(flight);
            flightTickets.remove(flight);
        }
    }

    // Implementation of the onBookFlight method from the BookFlightListener interface
    @Override
    public void onBookFlight(BookFlightEvent e, Scanner scanner) {
        passengerInputSystem.onBookFlight(this, scanner);
    }

    // Implementation of the onCancelFlight method from the CancelFlightListener interface
    @Override
    public void onCancelFlight(CancelFlightEvent event, Scanner scanner) {
        passengerInputSystem.onCancelFlight(this, scanner);
    }
}
