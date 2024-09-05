import airline.*;  // Importing airline package containing relevant classes

import java.util.Scanner;  // Importing Scanner for user input

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Creating a Scanner object to take user input
        FlightSystem.initFlights();  // Initializing the flight system with predefined flights

        // Display welcome message
        System.out.println("\nWelcome to airline system!\n");

        String username, password;

        // Taking username input from the user
        System.out.print("Enter username: ");
        username = scanner.nextLine();

        // Taking password input from the user
        System.out.print("Enter password: ");
        password = scanner.nextLine();

        // Logging in the user by checking credentials using UserService
        SysUser user = SysUser.login(username, password, new UserService());

        // If login fails, terminate the program
        if (user == null) {
            return;
        }

        // Check if the user is an Admin
        if (user.getUserType() == UserType.ADMIN) {
            Admin admin = (Admin) user;  // Cast user to Admin
            AdminEventsManager adminEventsManager = new AdminEventsManager();  // Create an event manager for admin actions

            // Admin event loop for different operations
            while (true) {
                OutputSystem.viewOptions(UserType.ADMIN);  // Display options for admin
                String choice = scanner.nextLine();

                try {
                    // Convert user input to AdminInput enum
                    AdminInput input = AdminInput.valueOf(choice.toUpperCase());

                    switch (input) {
                        case AdminInput.A:
                            // Register listener for adding new flight
                            adminEventsManager.connect_AddFlight(admin);
                            // Trigger the event to add a new flight
                            adminEventsManager.fireAddFlight(scanner);
                            break;
                        case AdminInput.B:
                            // Register listener for removing flight
                            adminEventsManager.connect_RemoveFlight(admin);
                            // Trigger the event to remove a flight
                            adminEventsManager.fireRemoveFlight(scanner);
                            break;
                        case AdminInput.C:
                            // Register listener for modifying flight
                            adminEventsManager.connect_ModifyFlight(admin);
                            // Trigger the event to modify a flight
                            adminEventsManager.fireModifyFlight(scanner);
                            break;
                        case AdminInput.D:
                            // Display all available flights
                            OutputSystem.printFlights();
                            break;
                        case AdminInput.E:
                            // Exit the system by logging out
                            System.out.println("Goodbye!");
                            return;
                    }
                } catch (IllegalArgumentException e) {
                    // If the user enters an invalid option, show error message
                    System.out.println("Invalid input!!");
                }
            }
        } else {
            // If the user is a Passenger
            Passenger passenger = (Passenger) user;  // Cast user to Passenger
            PassengerEventsManager passengerEventsManager = new PassengerEventsManager();  // Create event manager for passenger actions

            // Passenger event loop for different operations
            while (true) {
                OutputSystem.viewOptions(UserType.PASSENGER);  // Display options for passengers
                String choice = scanner.nextLine();

                try {
                    // Convert user input to PassengerInput enum
                    PassengerInput input = PassengerInput.valueOf(choice.toUpperCase());

                    switch (input) {
                        case A:
                            // Register listener for booking a flight
                            passengerEventsManager.connect_BookFlight(passenger);
                            // Trigger the event to book a flight
                            passengerEventsManager.fireBookFlight(scanner);
                            break;
                        case B:
                            // Register listener for canceling a flight
                            passengerEventsManager.connect_CancelFlight(passenger);
                            // Trigger the event to cancel a flight
                            passengerEventsManager.fireCancelFlight(scanner);
                            break;
                        case C:
                            // Display all available flights
                            OutputSystem.printFlights(passenger);
                            break;
                        case D:
                            // Exit the system by logging out
                            System.out.println("Goodbye!");
                            return;
                    }
                } catch (IllegalArgumentException e) {
                    // If the user enters an invalid option, show error message
                    System.out.println("Invalid input!!");
                }
            }
        }
    }
}
