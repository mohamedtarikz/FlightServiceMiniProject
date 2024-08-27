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
        dom_Flights.add(new Flight(FlightType.DOMESTIC,"Cairo","Aswan","30.8.2024","08:00"));
        dom_Flights.add(new Flight(FlightType.DOMESTIC,"Alexandria","Cairo","10.9.2024","10:00"));
        dom_Flights.add(new Flight(FlightType.DOMESTIC,"Hurghada","Luxor","20.9.2024","15:30"));
        dom_Flights.add(new Flight(FlightType.DOMESTIC,"Cairo","Hurghada","30.9.2024","11:00"));

        int_Flights.add(new Flight(FlightType.INTERNATIONAL,"Cairo","Amsterdam","6.10.2024","09:00"));
        int_Flights.add(new Flight(FlightType.INTERNATIONAL,"Moscow","Hurghada","8.9.2024","18:00"));
        int_Flights.add(new Flight(FlightType.INTERNATIONAL,"Cairo","London","6.11.2024","13:00"));
        int_Flights.add(new Flight(FlightType.INTERNATIONAL,"Berlin","Luxor","8.10.2024","11:00"));
        int_Flights.add(new Flight(FlightType.INTERNATIONAL,"Cairo","Riyad","7.11.2024","07:00"));

    }
    public void printAvailableFlights(FlightType flightType) {
        if(FlightType.INTERNATIONAL == flightType)
            printAvailableInternationalFlights();
        else
            printAvailableDomesticFlights();
    }



}
