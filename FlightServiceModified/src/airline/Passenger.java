package airline;

import java.util.*;

public class Passenger extends SysUser implements BookFlightListener, CancelFlightListener{
    private Map<Flight, Integer> flightTickets = new HashMap<Flight, Integer>();
    private List<Flight> flights = new ArrayList<Flight>();

    PassengerInputSystem passengerInputSystem = new PassengerInputSystem();
    public Passenger(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.PASSENGER);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public int getFlightTickets(Flight flight) {
        if (flight == null){
            return 0;
        }
        if (flightTickets.containsKey(flight)) {
            return flightTickets.get(flight);
        }
        else{
            return 0;
        }
    }

    public void addFlight(Flight flight, int tickets){
        if(flights.contains(flight)){
            flightTickets.compute(flight, (k, v) -> (v + tickets));
        }
        else{
            flights.add(flight);
            flightTickets.put(flight, tickets);
        }
    }
    public void removeFlight(Flight flight, int tickets){
        if(flightTickets.get(flight) - tickets > 0){
            flightTickets.compute(flight, (k, v) -> (v - tickets));
        }
        else{
            flights.remove(flight);
            flightTickets.remove(flight);
        }
    }

    @Override
    public void onBookFlight(BookFlightEvent e, Scanner scanner) {
        passengerInputSystem.onBookFlight(this,scanner);
    }

    @Override
    public void onCancelFlight(CancelFlightEvent event, Scanner scanner) {
        passengerInputSystem.onCancelFlight(this,scanner);
    }
}
