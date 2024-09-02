package airline;

import java.util.ArrayList;
import java.util.List;

public class FlightSystem {
    public static int num_dom = 0;
    public static int num_int = 0;
    private static List<Flight> domFlights = new ArrayList<Flight>();
    private static List<Flight> interFlights = new ArrayList<Flight>();

    public static void initFlights(){
        domFlights.add(new Flight("D"+ Integer.toString(++num_dom),FlightType.DOMESTIC,25,99.99,new Location("Cairo", "Egypt"),new Location("Aswan", "Egypt"),"30.8.2024","08:00"));
        domFlights.add(new Flight("D"+ Integer.toString(++num_dom),FlightType.DOMESTIC,10,124.99,new Location("Luxor", "Egypt"),new Location("Cairo", "Egypt"),"10.9.2024","10:00"));
        domFlights.add(new Flight("D"+ Integer.toString(++num_dom),FlightType.DOMESTIC,15,74.99,new Location("Hurghada", "Egypt"),new Location("Luxor", "Egypt"),"20.9.2024","15:30"));
        domFlights.add(new Flight("D"+ Integer.toString(++num_dom),FlightType.DOMESTIC,20,49.99,new Location("Cairo", "Egypt"),new Location("Hurghada", "Egypt"),"30.9.2024","11:00"));

        interFlights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,30,299.99,new Location("Cairo", "Egypt"),new Location("Amsterdam", "Netherlands"),"6.10.2024","09:00"));
        interFlights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,40,349.99,new Location("Moscow", "Russia"),new Location("Hurghada", "Egypt"),"8.9.2024","18:00"));
        interFlights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,35,274.99,new Location("Cairo", "Egypt"),new Location("London", "UK"),"6.11.2024","13:00"));
        interFlights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,40,299.99,new Location("Berlin", "Germany"),new Location("Luxor", "Egypt"),"8.10.2024","11:00"));
        interFlights.add(new Flight("I"+ Integer.toString(++num_int),FlightType.INTERNATIONAL,25,149.99,new Location("Cairo", "Egypt"),new Location("Riyad", "KSA"),"7.11.2024","07:00"));

    }

    public static void addFlight(Flight flight){

    }
}
