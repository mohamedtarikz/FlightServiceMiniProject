package airline;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String id;
    private FlightType flightType;
    private int seats;
    private double price;
    private int passengersCount;
    private Location from;
    private Location to;
    private String date;
    private String time;


    public Flight(String id, FlightType flightType, int seats,double price, Location from, Location to, String date, String time) {
        this.id = id;
        this.flightType = flightType;
        this.seats = seats;
        this.price = price;
        this.passengersCount = 0;
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

    public int getRemainingSeats() {
        return (seats - passengersCount);
    }
    public int getPassengersCount() {
        return passengersCount;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
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

    public void addPassenger(int count) {
        passengersCount += count;
    }
    public void removePassenger(int count) {
        passengersCount -= count;
    }

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

        return "";
    }
}
