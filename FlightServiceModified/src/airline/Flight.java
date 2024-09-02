package airline;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String id;
    private FlightType flightType;
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
        this.seats = seats;
        this.price = price;
        this.passengers = new ArrayList<Passenger>();
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
