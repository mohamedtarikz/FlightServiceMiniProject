package com.airline;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    private FlightType flightType;
    private int passengersCount;
    private int availableSeats;
    private List<Passenger> passengers;
    private String from;
    private String to;
    private String date;
    private String time;


    public Flight(FlightType flightType, String from, String to, String date, String time) {
        this.flightType = flightType;
        this.passengersCount = 0;
        this.availableSeats = 0;
        this.passengers = new ArrayList<Passenger>();
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;

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

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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
        System.out.println("Flight Type: " + this.flightType);
        System.out.println("From: " + this.from);
        System.out.println("To: " + this.to);
        System.out.println("Date: " + this.date);
        System.out.println("Time: " + this.time);
        System.out.println("Available Seats: " + this.availableSeats);
        System.out.println("Passengers: " + this.passengers);
        System.out.println("==================================================");

        return "";
    }
}
