package com.airline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlightReservationService {
    public static int num_dom = 0;
    public static int num_int = 0;
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
        dom_Flights.add(new Flight("D"+ Integer.toString(++num_dom),FlightType.DOMESTIC,new Location("Cairo", "Egypt"),new Location("Aswan", "Egypt"),"30.8.2024","08:00"));
        dom_Flights.add(new Flight("D"+ Integer.toString(++num_dom),FlightType.DOMESTIC,new Location("Luxor", "Egypt"),new Location("Cairo", "Egypt"),"10.9.2024","10:00"));
        dom_Flights.add(new Flight("D"+ Integer.toString(++num_dom),FlightType.DOMESTIC,new Location("Hurghada", "Egypt"),new Location("Luxor", "Egypt"),"20.9.2024","15:30"));
        dom_Flights.add(new Flight("D"+ Integer.toString(++num_dom),FlightType.DOMESTIC,new Location("Cairo", "Egypt"),new Location("Hurghada", "Egypt"),"30.9.2024","11:00"));

        int_Flights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,new Location("Cairo", "Egypt"),new Location("Amsterdam", "Netherlands"),"6.10.2024","09:00"));
        int_Flights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,new Location("Moscow", "Russia"),new Location("Hurghada", "Egypt"),"8.9.2024","18:00"));
        int_Flights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,new Location("Cairo", "Egypt"),new Location("London", "UK"),"6.11.2024","13:00"));
        int_Flights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,new Location("Berlin", "Germany"),new Location("Luxor", "Egypt"),"8.10.2024","11:00"));
        int_Flights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,new Location("Cairo", "Egypt"),new Location("Riyad", "KSA"),"7.11.2024","07:00"));

    }

    public void printAvailableFlights(FlightType flightType) {
        if(FlightType.INTERNATIONAL == flightType)
            printAvailableInternationalFlights();
        else
            printAvailableDomesticFlights();
    }
    public void printAvailableFlights() {
        printAvailableDomesticFlights();
        printAvailableInternationalFlights();
    }
    public void printAvailableIDs(){
        System.out.println("==============Domestic==============");
        for(Flight flight:dom_Flights){
            System.out.println("- " + flight.getId());
        }
        System.out.println();
        System.out.println("==============International==============");
        for (Flight flight:int_Flights){
            System.out.println("- " + flight.getId());
        }
        System.out.println();
    }
    public void addFlight(Flight flight){
        if(flight.getFlightType() == FlightType.INTERNATIONAL)
            int_Flights.add(flight);
        else
            dom_Flights.add(flight);
    }
    public void modifyFlightFrom(String id, String city, String country){
        if(id.charAt(0) == 'D'){
            Iterator<Flight> iterator = dom_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    item.setFrom(city,country);
                    if(!item.getFrom().getCountry().equals(item.getTo().getCountry())){
                        item.setId("I" + Integer.toString(++num_int));
                        int_Flights.add(item);
                        iterator.remove();
                    }
                }
            }
        }
        else if(id.charAt(0) == 'I'){
            Iterator<Flight> iterator = int_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    item.setFrom(city,country);
                    if(item.getFrom().getCountry().equals(item.getTo().getCountry())){
                        item.setId("D" + Integer.toString(++num_dom));
                        dom_Flights.add(item);
                        iterator.remove();
                    }
                }
            }
        }
    }
    public void modifyFlightTo(String id, String city, String country){
        if(id.charAt(0) == 'D'){
            Iterator<Flight> iterator = dom_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    item.setTo(city,country);
                    if(!item.getFrom().getCountry().equals(item.getTo().getCountry())){
                        item.setId("I" + Integer.toString(++num_int));
                        int_Flights.add(item);
                        iterator.remove();
                    }
                }
            }
        }
        else if(id.charAt(0) == 'I'){
            Iterator<Flight> iterator = int_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    item.setTo(city,country);
                    if(item.getFrom().getCountry().equals(item.getTo().getCountry())){
                        item.setId("D" + Integer.toString(++num_dom));
                        dom_Flights.add(item);
                        iterator.remove();
                    }
                }
            }
        }
    }
    public void modifyFlightDate(String id, String date){
        if(id.charAt(0) == 'D'){
            Iterator<Flight> iterator = dom_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    item.setDate(date);
                }
            }
        }
        else if(id.charAt(0) == 'I'){
            Iterator<Flight> iterator = int_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    item.setDate(date);
                }
            }
        }
    }
    public void modifyFlightTime(String id, String time){
        if(id.charAt(0) == 'D'){
            Iterator<Flight> iterator = dom_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    item.setTime(time);
                }
            }
        }
        else if(id.charAt(0) == 'I'){
            Iterator<Flight> iterator = int_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    item.setTime(time);
                }
            }
        }
    }

    public boolean checkForID(String id){
        return (int_Flights.stream().anyMatch(flight -> flight.getId().equals(id)) || dom_Flights.stream().anyMatch(flight -> flight.getId().equals(id)));
    }
    public boolean remFlight(String id){
        if(id.charAt(0) == 'D'){
            boolean found = false;
            Iterator<Flight> iterator = dom_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    iterator.remove();
                    found = true;
                }
            }
            return found;
        }
        else if(id.charAt(0) == 'I'){
            boolean found = false;
            Iterator<Flight> iterator = int_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    iterator.remove();
                    found = true;
                }
            }
            return found;
        }
        else{
            return false;
        }
    }
    public boolean printFlight(String id){
        boolean found = false;
        if(id.charAt(0) == 'D'){
            Iterator<Flight> iterator = dom_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    System.out.println(item);
                    found = true;
                }
            }
        }
        else if(id.charAt(0) == 'I'){
            Iterator<Flight> iterator = int_Flights.iterator();
            while(iterator.hasNext()){
                Flight item = iterator.next();
                if(item.getId().equals(id)){
                    System.out.println(item);
                    found = true;
                }
            }
        }
        return found;
    }
}
