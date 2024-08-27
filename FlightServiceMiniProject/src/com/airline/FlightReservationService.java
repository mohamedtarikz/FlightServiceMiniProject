package com.airline;

import java.util.ArrayList;
import java.util.List;

public class FlightReservationService {

    private List<Flight> dom_Flights = new ArrayList<>();
    private List<Flight> int_Flights = new ArrayList<>();
    private void printAvailableInternationalFlights() {
        System.out.println(dom_Flights);
    }

    private void printAvailableDomesticFlights() {
        System.out.println(int_Flights);
    }


    public void printAvailableFlights(FlightType flightType) {
        if(FlightType.INTERNATIONAL == flightType)
            printAvailableInternationalFlights();
        else
            printAvailableDomesticFlights();
    }



}
