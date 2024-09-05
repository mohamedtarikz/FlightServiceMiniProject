package airline;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    // Flight attributes
    private final String id;  // Unique identifier for the flight
    private FlightType flightType;  // Type of flight (e.g., domestic, international)
    private int seats;  // Total number of seats on the flight
    private double price;  // Price per seat
    private int passengersCount;  // Number of passengers booked on the flight
    private Location from;  // Departure location
    private Location to;  // Destination location
    private String date;  // Date of the flight (DD.MM.YYYY)
    private String time;  // Time of the flight (HH:MM)

    // Constructor for initializing a flight with details
    public Flight(String id, FlightType flightType, int seats, double price, Location from, Location to, String date, String time) {
        this.id = id;
        this.flightType = flightType;
        this.seats = seats;
        this.price = price;
        this.passengersCount = 0;  // Initialize with 0 passengers booked
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
    }

    // Getter for Flight ID
    public String getId() {
        return id;
    }

    // Getter for Flight Type
    public FlightType getFlightType() {
        return flightType;
    }

    // Setter for Seats
    public void setSeats(int seats) {
        this.seats = seats;
    }

    // Getter for Price per seat
    public double getPrice() {
        return price;
    }

    // Setter for Price per seat
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for Remaining Seats (Total seats - booked seats)
    public int getRemainingSeats() {
        return (seats - passengersCount);
    }

    // Getter for Departure Location
    public Location getFrom() {
        return from;
    }

    // Getter for Destination Location
    public Location getTo() {
        return to;
    }

    // Getter for Flight Date
    public String getDate() {
        return date;
    }

    // Setter for Flight Date
    public void setDate(String date) {
        this.date = date;
    }

    // Getter for Flight Time
    public String getTime() {
        return time;
    }

    // Setter for Flight Time
    public void setTime(String time) {
        this.time = time;
    }

    // Method to add passengers to the flight
    public void addPassenger(int count) {
        passengersCount += count;
    }

    // Method to remove passengers from the flight
    public void removePassenger(int count) {
        passengersCount -= count;
    }

    // Overriding toString method to display flight details
    @Override
    public String toString() {
        System.out.println("================================================");
        System.out.println("    FlightID = " + id);
        System.out.println("    Take-off = " + from.getCity() + ", " + from.getCountry());
        System.out.println("    Destination = " + to.getCity() + ", " + to.getCountry());
        System.out.println("    Date = " + date);
        System.out.println("    Time = " + time);
        System.out.println("    Remaining Seats = " + getRemainingSeats());
        System.out.println("    Price = " + price);
        System.out.println("================================================");

        return "";  // Returning empty string as the actual output is printed above
    }
}
