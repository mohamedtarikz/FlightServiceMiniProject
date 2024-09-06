package airline;

import java.util.Scanner;

public class Admin extends SysUser implements AddFlightListener, RemoveFlightListener, ModifyFlightListener {
    AdminInputSystem adminInputSystem = new AdminInputSystem();  // Creating an instance of AdminInputSystem to handle admin operations

    // Constructor to initialize Admin with a username and password
    public Admin(String name, String pass) {
        this.username = name;  // Setting username of the admin
        this.password = pass;  // Setting password of the admin
        this.userType = UserType.ADMIN;  // Setting the user type as ADMIN
    }

    // Overriding the onAddFlight method from AddFlightListener interface
    @Override
    public void onAddFlight(AddFlightEvent event, Scanner scanner) {
        // Handling the event by invoking the admin input system's method to add a flight
        adminInputSystem.onAddFlight(scanner);
    }

    // Overriding the onRemoveFlight method from RemoveFlightListener interface
    @Override
    public void onRemoveFlight(RemoveFlightEvent event, Scanner scanner) {
        // Handling the event by invoking the admin input system's method to remove a flight
        adminInputSystem.onRemoveFlight(scanner);
    }

    // Overriding the onModifyFlight method from ModifyFlightListener interface
    @Override
    public void onModifyFlight(ModifyFlightEvent event, Scanner scanner) {
        // Handling the event by invoking the admin input system's method to modify a flight
        adminInputSystem.onModifyFlight(scanner);
    }
}
