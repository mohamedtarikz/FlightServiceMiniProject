package airline;

import java.util.ArrayList;
import java.util.List;

public class FlightSystem{
    public static int num_dom = 0;
    public static int num_int = 0;
    private static List<Flight> domFlights = new ArrayList<Flight>();
    private static List<Flight> interFlights = new ArrayList<Flight>();

    public static void initFlights(){
        domFlights.add(new Flight("D"+ (++num_dom),FlightType.DOMESTIC,25,99.99,new Location("Cairo", "Egypt"),new Location("Aswan", "Egypt"),"30.8.2024","08:00"));
        domFlights.add(new Flight("D"+ (++num_dom),FlightType.DOMESTIC,10,124.99,new Location("Luxor", "Egypt"),new Location("Cairo", "Egypt"),"10.9.2024","10:00"));
        domFlights.add(new Flight("D"+ (++num_dom),FlightType.DOMESTIC,15,74.99,new Location("Hurghada", "Egypt"),new Location("Luxor", "Egypt"),"20.9.2024","15:30"));
        domFlights.add(new Flight("D"+ (++num_dom),FlightType.DOMESTIC,20,49.99,new Location("Cairo", "Egypt"),new Location("Hurghada", "Egypt"),"30.9.2024","11:00"));

        interFlights.add(new Flight("I"+ (++num_int),FlightType.INTERNATIONAL,30,299.99,new Location("Cairo", "Egypt"),new Location("Amsterdam", "Netherlands"),"6.10.2024","09:00"));
        interFlights.add(new Flight("I"+ (++num_int),FlightType.INTERNATIONAL,40,349.99,new Location("Moscow", "Russia"),new Location("Hurghada", "Egypt"),"8.9.2024","18:00"));
        interFlights.add(new Flight("I"+ (++num_int),FlightType.INTERNATIONAL,35,274.99,new Location("Cairo", "Egypt"),new Location("London", "UK"),"6.11.2024","13:00"));
        interFlights.add(new Flight("I"+ (++num_int),FlightType.INTERNATIONAL,40,299.99,new Location("Berlin", "Germany"),new Location("Luxor", "Egypt"),"8.10.2024","11:00"));
        interFlights.add(new Flight("I"+ (++num_int),FlightType.INTERNATIONAL,25,149.99,new Location("Cairo", "Egypt"),new Location("Riyad", "KSA"),"7.11.2024","07:00"));

    }
    public static List<Flight> getFlights(FlightType type){
        if(type == FlightType.DOMESTIC)
            return domFlights;
        else if(type == FlightType.INTERNATIONAL)
            return interFlights;
        return null;
    }
    public static Flight getFlight(String id){
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
        return null;
    }

    public static void addFlight(Location from, Location to, String date, String time, int seats, double price){
        if(from.getCountry().equals(to.getCountry()))
            domFlights.add(new Flight("D" + (++num_dom),FlightType.DOMESTIC,seats,price,from,to,date,time));
        else
            interFlights.add(new Flight("I" + (++num_int),FlightType.INTERNATIONAL,seats,price,from,to,date,time));
    }
    public static boolean removeFlight(String id) {
        Flight flight = getFlight(id);
        if (flight == null){
            return false;
        }
        if (flight.getFlightType() == FlightType.DOMESTIC) {
            domFlights.remove(flight);
            return true;
        } else {
            interFlights.remove(flight);
            return true;
        }
    }
    public static void modifyFlight(String id, ModificationOptions option, String value) {
        Flight flightMod = getFlight(id);
        if (flightMod == null) {
            return;
        }
        switch (option) {
            case A :
                flightMod.setDate(value);
                break;
            case B :
                flightMod.setTime(value);
                break;
            case C :
                flightMod.setSeats(Integer.parseInt(value));
                break;
            case D :
                flightMod.setPrice(Double.parseDouble(value));
        }
    }

    public static void bookFlight(Passenger passenger, FlightType flightType, String id, int tickets){
        Flight flight = getFlight(id);
        if (flight == null) {
            return;
        }
        if (flight.getRemainingSeats() >= tickets) {
            passenger.addFlight(flight, tickets);
            flight.addPassenger(tickets);
            System.out.println("You have successfully booked a flight");
        }
        else{
            System.out.println("Sorry, there are not enough seats available");
        }
    }
    public static void cancelFlight(Passenger passenger, String id, int bookedTickets, int tickets){
        Flight flight = getFlight(id);
        if (flight == null) {
            return;
        }
        if (bookedTickets < tickets) {
            System.out.println("You do not have enough tickets");
        }
        else{
            flight.removePassenger(tickets);
        }
    }
    public static void printFlights(){
        System.out.println("Domestic flights");
    }
}
