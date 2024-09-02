
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
            InputSystem inputSystem = new InputSystem();
            AdminEventsManager eventsManager = new AdminEventsManager();
            while(true) {
                admin.viewOptions();
                String choice = scanner.nextLine();
                try {
                    AdminInput input = AdminInput.valueOf(choice.toUpperCase());
                    switch (input) {
                        case AdminInput.A:
                            // Register listener for adding new flight
                            eventsManager.add_AddFlight_Listener(inputSystem);
                            // Fire event to add new flight
                            eventsManager.fireAddFlight(admin, scanner);
                            // Remove Listener after the event is done
                            eventsManager.remove_AddFlight_Listener(inputSystem);
                            break;
                        case AdminInput.B:
                            // Register listener for removing flight
                            eventsManager.add_RemoveFlight_Listener(inputSystem);
                            // Fire event to remove flight
                            eventsManager.fireRemoveFlight(admin, scanner);
                            // Remove Listener after the event is done
                            eventsManager.remove_RemoveFlight_Listener(inputSystem);
                            break;
                        case AdminInput.C:
                            //
                            break;
                        case AdminInput.D:
                            //
                            break;
                        case AdminInput.E:
                            return;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input!!");
                }
            }
        }
        else{
            Passenger passenger = (Passenger)user;
            passenger.viewOptions();
        }
    }
}