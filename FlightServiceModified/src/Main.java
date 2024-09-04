
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
            AdminInputSystem adminInputSystem = new AdminInputSystem();
            AdminEventsManager adminEventsManager = new AdminEventsManager();
            while(true) {
                OutputSystem.viewOptions(UserType.ADMIN);
                String choice = scanner.nextLine();
                try {
                    AdminInput input = AdminInput.valueOf(choice.toUpperCase());
                    switch (input) {
                        case AdminInput.A:
                            // Register listener for adding new flight
                            adminEventsManager.add_AddFlight_Listener(adminInputSystem);
                            // Fire event to add new flight
                            adminEventsManager.fireAddFlight(admin, scanner);
                            break;
                        case AdminInput.B:
                            // Register listener for removing flight
                            adminEventsManager.add_RemoveFlight_Listener(adminInputSystem);
                            // Fire event to remove flight
                            adminEventsManager.fireRemoveFlight(admin, scanner);
                            break;
                        case AdminInput.C:
                            // Register listener for modifying flight
                            adminEventsManager.add_ModifyFlight_Listener(adminInputSystem);
                            // Fire event to modify flight
                            adminEventsManager.fireModifyFlight(admin, scanner);
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
            OutputSystem.viewOptions(UserType.PASSENGER);
        }
    }
}