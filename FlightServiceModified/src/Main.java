
import airline.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightSystem.initFlights();

        System.out.println("\nWelcome to airline system!\n");

        String username,password;
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();
        SysUser user = SysUser.login(username,password,new UserService());

        if (user == null) {
            return;
        }

        if(user.getUserType() == UserType.ADMIN){
            Admin admin = (Admin)user;
            AdminEventsManager adminEventsManager = new AdminEventsManager();
            while(true) {
                OutputSystem.viewOptions(UserType.ADMIN);
                String choice = scanner.nextLine();
                try {
                    AdminInput input = AdminInput.valueOf(choice.toUpperCase());
                    switch (input) {
                        case AdminInput.A:
                            // Register listener for adding new flight
                            adminEventsManager.connect_AddFlight(admin);
                            // Fire event to add new flight
                            adminEventsManager.fireAddFlight(scanner);
                            break;
                        case AdminInput.B:
                            // Register listener for removing flight
                            adminEventsManager.connect_RemoveFlight(admin);
                            // Fire event to remove flight
                            adminEventsManager.fireRemoveFlight(scanner);
                            break;
                        case AdminInput.C:
                            // Register listener for modifying flight
                            adminEventsManager.connect_ModifyFlight(admin);
                            // Fire event to modify flight
                            adminEventsManager.fireModifyFlight(scanner);
                            break;
                        case AdminInput.D:
                            // View all flights
                            OutputSystem.printFlights();
                            break;
                        case AdminInput.E:
                            // Logout and exit
                            System.out.println("Goodbye!");
                            return;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input!!");
                }
            }
        }
        else{
            Passenger passenger = (Passenger)user;
            PassengerEventsManager passengerEventsManager = new PassengerEventsManager();
            while (true) {
                OutputSystem.viewOptions(UserType.PASSENGER);
                String choice = scanner.nextLine();
                try {
                    PassengerInput input = PassengerInput.valueOf(choice.toUpperCase());
                    switch (input) {
                        case A:
                            // Register listener for adding new flight
                            passengerEventsManager.connect_BookFlight(passenger);
                            // Fire event to add new flight
                            passengerEventsManager.fireBookFlight(scanner);
                            break;
                        case B:
                            // Register listener for removing flight
                            passengerEventsManager.connect_CancelFlight(passenger);
                            // Fire event to remove flight
                            passengerEventsManager.fireCancelFlight(scanner);
                            break;
                        case C:
                            // View all flights
                            OutputSystem.printFlights(passenger);
                            break;
                        case D:
                            // Logout and exit
                            System.out.println("Goodbye!");
                            return;
                    }
                }catch (IllegalArgumentException e){
                    System.out.println("Invalid input!!");
                }
            }
        }
    }
}