package com.airline;

import java.util.ArrayList;
import java.util.List;

public class FlightReservationService {

    public FlightReservationService(){
        InitFlights();
    }

    private List<Flight> dom_Flights = new ArrayList<>();
    private List<Flight> int_Flights = new ArrayList<>();

    private void printAvailableInternationalFlights() {
        System.out.println(dom_Flights);
    }
    private void printAvailableDomesticFlights() {
        System.out.println(int_Flights);
    }
    private void InitFlights(){
        dom_Flights.add(new Flight(FlightType.DOMESTIC,new Location("Cairo", "Egypt"),new Location("Aswan", "Egypt"),"30.8.2024","08:00"));
        dom_Flights.add(new Flight(FlightType.DOMESTIC,new Location("Luxor", "Egypt"),new Location("Cairo", "Egypt"),"10.9.2024","10:00"));
        dom_Flights.add(new Flight(FlightType.DOMESTIC,new Location("Hurghada", "Egypt"),new Location("Luxor", "Egypt"),"20.9.2024","15:30"));
        dom_Flights.add(new Flight(FlightType.DOMESTIC,new Location("Cairo", "Egypt"),new Location("Hurghada", "Egypt"),"30.9.2024","11:00"));

        int_Flights.add(new Flight(FlightType.INTERNATIONAL,new Location("Cairo", "Egypt"),new Location("Amsterdam", "Netherlands"),"6.10.2024","09:00"));
        int_Flights.add(new Flight(FlightType.INTERNATIONAL,new Location("Moscow", "Russia"),new Location("Hurghada", "Egypt"),"8.9.2024","18:00"));
        int_Flights.add(new Flight(FlightType.INTERNATIONAL,new Location("Cairo", "Egypt"),new Location("London", "UK"),"6.11.2024","13:00"));
        int_Flights.add(new Flight(FlightType.INTERNATIONAL,new Location("Berlin", "Germany"),new Location("Luxor", "Egypt"),"8.10.2024","11:00"));
        int_Flights.add(new Flight(FlightType.INTERNATIONAL,new Location("Cairo", "Egypt"),new Location("Riyad", "KSA"),"7.11.2024","07:00"));

    }

    public void printAvailableFlights(FlightType flightType) {
        if(FlightType.INTERNATIONAL == flightType)
            printAvailableInternationalFlights();
        else
            printAvailableDomesticFlights();
    }
    public void addFlight(Flight flight){
        if(flight.getFlightType() == FlightType.INTERNATIONAL)
            int_Flights.add(flight);
        else
            dom_Flights.add(flight);
    }
}
