package airline;

import java.util.*;

public class Passenger extends SysUser implements BookFlightListener, CancelFlightListener {

    // Instance of PassengerInputSystem to handle user input for booking and cancelling flights
    PassengerInputSystem passengerInputSystem = new PassengerInputSystem();

    // Cart to store the flight details of the passenger
    private Cart cart = new Cart();

    // Constructor to initialize the Passenger object with a username, password, and user type
    public Passenger(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.PASSENGER);
    }

    // Method to handle user input for booking and cancelling flights
    public Cart getCart() {
        return cart;
    }

    // Implementation of the onBookFlight method from the BookFlightListener interface
    @Override
    public void onBookFlight(BookFlightEvent e, Scanner scanner) {
        passengerInputSystem.onBookFlight(this.cart, scanner);
    }

    // Implementation of the onCancelFlight method from the CancelFlightListener interface
    @Override
    public void onCancelFlight(CancelFlightEvent event, Scanner scanner) {
        passengerInputSystem.onCancelFlight(this.cart, scanner);
    }
}
