package airline;

import java.util.Scanner;

public class Admin extends SysUser {
    public Admin(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.ADMIN);
    }

    public void addFlight(Location from, Location to, String date, String time, int seats, double price) {
        if (from.getCountry().equals(to.getCountry())){
            FlightSystem.addFlight(new Flight("D" + (++FlightSystem.num_dom),FlightType.DOMESTIC,seats,price,from,to,date,time));
        }
        else{
            FlightSystem.addFlight(new Flight("I" + (++FlightSystem.num_int),FlightType.INTERNATIONAL,seats,price,from,to,date,time));
        }
    }
    public boolean removeFlight(String flight_id) {
        return FlightSystem.removeFlight(flight_id);
    }
    public void modifyFlight(String flightID, ModificationOptions option, String value) {
        FlightSystem.modifyFlight(flightID,option,value);
    }
}
