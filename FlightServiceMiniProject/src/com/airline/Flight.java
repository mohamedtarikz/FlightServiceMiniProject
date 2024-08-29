package com.airline;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String id;
    private FlightType flightType;
    private int passengersCount;
    private int availableSeats;
    private List<Passenger> passengers;
    private Location from;
    private Location to;
    private String date;
    private String time;


    public Flight(String id, FlightType flightType, Location from, Location to, String date, String time) {
        this.id = id;
        this.flightType = flightType;
        this.passengersCount = 0;
        this.availableSeats = 0;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(String city, String country) {
        this.to.setCity(city);
        this.to.setCountry(country);
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(String city, String country) {
        this.from.setCity(city);
        this.from.setCountry(country);
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    private boolean bookSeat(){
        return true;
    }

    private List<Passenger> getPassengers(){
        return this.passengers;
    }

    private int getAvailableSeats(){
        return this.availableSeats;
    }


    @Override
    public String toString() {

        System.out.println("========================= Print Flight ======================");
        System.out.println("ID: " + this.id);
        System.out.println("From: " + this.from.getCity() + ", " + this.from.getCountry());
        System.out.println("To: " + this.to.getCity() + ", " + this.to.getCountry());
        System.out.println("Date: " + this.date);
        System.out.println("Time: " + this.time);
        System.out.println("Available Seats: " + this.availableSeats);
        System.out.println("Passengers: " + this.passengers);
        System.out.println("==================================================");

        return "";
    }
}
