package airline;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String id;
    private FlightType flightType;
    private int availableSeats;
    private int seats;
    private double price;
    private List<Passenger> passengers;
    private Location from;
    private Location to;
    private String date;
    private String time;


    public Flight(String id, FlightType flightType, int seats,double price, Location from, Location to, String date, String time) {
        this.id = id;
        this.flightType = flightType;
        this.availableSeats = seats;
        this.seats = seats;
        this.price = price;
        this.passengers = new ArrayList<Passenger>();
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
    }
}
