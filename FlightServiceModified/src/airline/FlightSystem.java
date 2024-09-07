package airline;

import java.util.ArrayList;
import java.util.List;

public class FlightSystem {
    // Counters for the number of domestic and international flights
    public static int num_dom = 0;
    public static int num_int = 0;

    // Lists to store domestic and international flights
    private static List<Flight> domFlights = new ArrayList<Flight>();
    private static List<Flight> interFlights = new ArrayList<Flight>();

    // Initialize sample flights for testing or demonstration
    public static void initFlights() {
        // Adding some domestic flights
        domFlights.add(new Flight("D" + (++num_dom), FlightType.DOMESTIC, 25, 99.99, new Location("Cairo", "Egypt"), new Location("Aswan", "Egypt"), "30.8.2024", "08:00"));
        domFlights.add(new Flight("D" + (++num_dom), FlightType.DOMESTIC, 10, 124.99, new Location("Luxor", "Egypt"), new Location("Cairo", "Egypt"), "10.9.2024", "10:00"));
        domFlights.add(new Flight("D" + (++num_dom), FlightType.DOMESTIC, 15, 74.99, new Location("Hurghada", "Egypt"), new Location("Luxor", "Egypt"), "20.9.2024", "15:30"));
        domFlights.add(new Flight("D" + (++num_dom), FlightType.DOMESTIC, 20, 49.99, new Location("Cairo", "Egypt"), new Location("Hurghada", "Egypt"), "30.9.2024", "11:00"));

        // Adding some international flights
        interFlights.add(new Flight("I" + (++num_int), FlightType.INTERNATIONAL, 30, 299.99, new Location("Cairo", "Egypt"), new Location("Amsterdam", "Netherlands"), "6.10.2024", "09:00"));
        interFlights.add(new Flight("I" + (++num_int), FlightType.INTERNATIONAL, 40, 349.99, new Location("Moscow", "Russia"), new Location("Hurghada", "Egypt"), "8.9.2024", "18:00"));
        interFlights.add(new Flight("I" + (++num_int), FlightType.INTERNATIONAL, 35, 274.99, new Location("Cairo", "Egypt"), new Location("London", "UK"), "6.11.2024", "13:00"));
        interFlights.add(new Flight("I" + (++num_int), FlightType.INTERNATIONAL, 40, 299.99, new Location("Berlin", "Germany"), new Location("Luxor", "Egypt"), "8.10.2024", "11:00"));
        interFlights.add(new Flight("I" + (++num_int), FlightType.INTERNATIONAL, 25, 149.99, new Location("Cairo", "Egypt"), new Location("Riyad", "KSA"), "7.11.2024", "07:00"));
    }

    // Retrieve a list of flights based on the type (domestic or international)
    public static List<Flight> getFlights(FlightType type) {
        if (type == FlightType.DOMESTIC) {
            return domFlights;
        } else if (type == FlightType.INTERNATIONAL) {
            return interFlights;
        }
        return null;
    }

    // Retrieve a specific flight based on its ID
    public static Flight getFlight(String id) {
        for (Flight flight : domFlights) {
            if (flight.getId().equals(id)) {
                return flight;
            }
        }
        for (Flight flight : interFlights) {
            if (flight.getId().equals(id)) {
                return flight;
            }
        }
        return null; // Return null if no matching flight is found
    }

    // Add a new flight to the system based on its type
    public static void addFlight(Location from, Location to, String date, String time, int seats, double price) {
        if (from.getCountry().equals(to.getCountry())) {
            domFlights.add(new Flight("D" + (++num_dom), FlightType.DOMESTIC, seats, price, from, to, date, time));
        } else {
            interFlights.add(new Flight("I" + (++num_int), FlightType.INTERNATIONAL, seats, price, from, to, date, time));
        }
    }

    // Remove a flight from the system by its ID
    public static boolean removeFlight(String id) {
        Flight flight = getFlight(id);
        if (flight == null) {
            return false; // Return false if the flight does not exist
        }
        // Remove the flight from the appropriate list based on its type
        if (flight.getFlightType() == FlightType.DOMESTIC) {
            domFlights.remove(flight);
        } else {
            interFlights.remove(flight);
        }
        return true;
    }

    // Modify specific details of a flight based on the provided option and value
    public static void modifyFlight(String id, ModificationOptions option, String value) {
        Flight flightMod = getFlight(id); // Find the flight by its ID
        if (flightMod == null) {
            return; // Return if the flight does not exist
        }
        // Modify the flight based on the selected option (A = Date, B = Time, C = Seats, D = Price)
        switch (option) {
            case A:
                flightMod.setDate(value);
                break;
            case B:
                flightMod.setTime(value);
                break;
            case C:
                flightMod.setSeats(Integer.parseInt(value));
                break;
            case D:
                flightMod.setPrice(Double.parseDouble(value));
                break;
        }
    }

    // Book a flight for a passenger, ensuring there are enough seats available
    public static void bookFlight(Cart cart, String id, int tickets) {
        Flight flight = getFlight(id); // Find the flight by its ID
        if (flight == null) {
            return; // Return if no flight is found
        }
        // Check if enough seats are available for the booking
        if (flight.getRemainingSeats() >= tickets) {
            cart.addFlight(flight, tickets); // Add the flight to the passenger's booking
            flight.addPassenger(tickets); // Update the flight's passenger count
            System.out.println("You have successfully booked a flight");
        } else {
            System.out.println("Sorry, there are not enough seats available");
        }
    }

    // Cancel a flight for a passenger, ensuring the passenger has enough tickets
    public static void cancelFlight(Cart cart, String id, int bookedTickets, int tickets) {
        Flight flight = getFlight(id); // Find the flight by its ID
        if (flight == null) {
            return; // Return if no flight is found
        }
        // Ensure the passenger has enough booked tickets to cancel
        if (bookedTickets < tickets) {
            System.out.println("You do not have enough tickets");
        } else {
            flight.removePassenger(tickets); // Remove the tickets from the flight
            cart.removeFlight(flight, tickets); // Remove the flight from the passenger's bookings
        }
    }
}
