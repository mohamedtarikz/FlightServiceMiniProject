package com.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Passenger extends SystemUser{
    private List<Flight> flights = new ArrayList<Flight>();
    private Map<Flight, Integer> mp = new HashMap<Flight, Integer>();

    public Passenger(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.PASSENGER);
    }

    public int getTickets(Flight flight) {
        return mp.get(flight);
    }
    public void bookFlight(Flight flight, int tickets) {
        if (flights.contains(flight)) {
            mp.computeIfPresent(flight, (k, v) -> v + tickets);
        }
        else{
            flights.add(flight);
            mp.put(flight, tickets);
        }
    }
    public void cancelFlight(String id, int tickets) {
        for (Flight flight : flights) {
            if (flight.getId().equals(id)) {
                if (mp.get(flight) >= tickets) {
                    mp.computeIfPresent(flight, (k, v) -> v - tickets);
                }
                else{
                    flights.remove(flight);
                    mp.remove(flight);
                }
            }
        }
    }
    @Override
    public boolean printFlights() {
        if (!flights.isEmpty()) {
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
        return (!flights.isEmpty());
    }

    @Override
    public boolean getFlightInfo(String id) {
        for (Flight flight : flights){
            if (flight.getId().equals(id)) {
                System.out.println("===============================================================");
                System.out.println("ID: " + flight.getId());
                System.out.println("Departure: " + flight.getFrom().getCity());
                System.out.println("Arrival: " + flight.getTo().getCity());
                System.out.println("Price per ticket: " + flight.getPrice());
                System.out.println("Tickets booked: " + mp.get(flight));
                System.out.println("===============================================================");
                return true;
            }
        }
        return false;
    }
}
