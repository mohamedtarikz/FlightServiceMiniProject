
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
            while(true) {
                admin.viewOptions();
                String choice = scanner.nextLine();
                try {
                    AdminInput input = AdminInput.valueOf(choice.toUpperCase());
                    switch (input) {
                        case AdminInput.A:
                            //Take the flight details from admin
                            //Confirm the departure and destination//
                            System.out.println("Enter the departure location in the form 'City, Country': ");
                            Location From = InputSystem.takeLocationInput(scanner);
                            if(From == null) {
                                continue;
                            }
                            System.out.println("Enter the destination in the form 'City, Country': ");
                            Location To = InputSystem.takeLocationInput(scanner);
                            if(To == null) {
                                continue;
                            }
                            ////////////////////////////////////////////////
                            //Confirm the departure date and time//
                            System.out.println("Enter the departure date in the form 'DD-MM-YYYY': ");
                            String date = InputSystem.takeDateInput(scanner);
                            System.out.println("Enter the departure time in the form 'HH:MM': ");
                            String time = InputSystem.takeTimeInput(scanner);
                            if(date == null || time == null) {
                                continue;
                            }
                            ////////////////////////////////////////////////
                            //Confirm the seats number and price//
                            System.out.println("Enter the number of seats: ");
                            int seats = InputSystem.takeSeatsInput(scanner);
                            System.out.println("Enter the price per seat: ");
                            double price = InputSystem.takePriceInput(scanner);
                            if(seats == -1 || price == -1) {
                                continue;
                            }
                            ////////////////////////////////////////////////
                            //Create a new flight//
                            admin.addFlight(From, To, date, time, seats, price);
                            System.out.println("Flight added successfully!");
                            ////////////////////////////////////////////////
                            break;
                        case AdminInput.B:
                            //
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