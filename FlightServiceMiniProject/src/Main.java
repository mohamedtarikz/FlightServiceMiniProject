import com.airline.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the flight reservation and user services
        FlightReservationService service = new FlightReservationService();
        UserService userService = new UserService();

        // Prompt the user to log in
        String username, pass;
        System.out.print("Please enter your username: ");
        username = scanner.nextLine().toLowerCase(Locale.ENGLISH); // Convert username to lowercase
        System.out.print("Please enter your password: ");
        pass = scanner.nextLine();

        // Attempt to log in the user
        SystemUser user = SystemUser.login(username, pass, userService);
        if (user != null) {
            System.out.println("You have successfully logged in " + user.getUsername() + "!");
        } else {
            System.out.println("Wrong Credentials!");
        }

        // Main loop: continue to interact with the user until they sign out
        while (user != null) {
            // Admin user operations
            if (user.getUserType() == UserType.ADMIN) {
                System.out.println("\n1- Add Flight\n2- Remove Flight\n3- Modify Flight\n4- Sign out");
                String choice = scanner.nextLine();

                // Add a new flight
                if (choice.equals("1")) {
                    System.out.println("Enter starting location in the form 'City, Country': ");
                    String from = scanner.nextLine();
                    // Validate the input format for location
                    if (!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+", from)) {
                        System.out.println("Invalid Format! Format should be 'City, Country'!!");
                        continue;
                    }
                    // Extract city and country from the input
                    Pattern pattern = Pattern.compile("[a-zA-Z]+");
                    Matcher matcher = pattern.matcher(from);
                    String fromCity = "", fromCountry = "";
                    if (matcher.find())
                        fromCity = matcher.group().toUpperCase();
                    if (matcher.find())
                        fromCountry = matcher.group().toUpperCase();

                    System.out.println("Enter destination location in the form 'City, Country': ");
                    String to = scanner.nextLine();
                    // Validate the input format for location
                    if (!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+", to)) {
                        System.out.println("Invalid Format! Format should be 'City, Country'!!");
                        continue;
                    }
                    // Extract city and country from the input
                    matcher = pattern.matcher(to);
                    String toCity = "", toCountry = "";
                    if (matcher.find())
                        toCity = matcher.group().toUpperCase();
                    if (matcher.find())
                        toCountry = matcher.group().toUpperCase();

                    // Get the number of seats
                    System.out.println("Enter number of seats: ");
                    String seats = scanner.nextLine();
                    if (!Pattern.matches("\\d+", seats)) {
                        System.out.println("Invalid Input!!");
                        continue;
                    }
                    int seats_num = Integer.parseInt(seats);

                    // Get the price of the flight
                    System.out.println("Enter price of flight: ");
                    String price = scanner.nextLine();
                    if (!Pattern.matches("\\d+(\\.(0[1-9]|[1-9][0-9]))?", price)) {
                        System.out.println("Invalid Input!!");
                        continue;
                    }
                    double price_num = Double.parseDouble(price);

                    // Get the date of the flight
                    System.out.println("Enter date of the flight in the form 'DD.MM.YYYY': ");
                    String date = scanner.nextLine();
                    while (!Pattern.matches("(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(20(2[4-9]|[3-9][0-9]))", date)) {
                        System.out.println("Invalid Input!!");
                        date = scanner.nextLine();
                    }

                    // Get the time of the flight
                    System.out.println("Enter time of the flight in the form 'HH:MM' (24hr-system): ");
                    String time = scanner.nextLine();
                    while (!Pattern.matches("([0-1][0-9]|2[0-3])\\:([0-5][0-9])", time)) {
                        System.out.println("Invalid Input!!");
                        time = scanner.nextLine();
                    }

                    // Determine if the flight is domestic or international based on the country
                    if (fromCountry.equals(toCountry)) {
                        service.addFlight(new Flight("D" + Integer.toString(++FlightReservationService.num_dom), FlightType.DOMESTIC, seats_num, price_num, new Location(fromCity, fromCountry), new Location(toCity, toCountry), date, time));
                    } else {
                        service.addFlight(new Flight("I" + Integer.toString(++FlightReservationService.num_int), FlightType.INTERNATIONAL, seats_num, price_num, new Location(fromCity, fromCountry), new Location(toCity, toCountry), date, time));
                    }
                    System.out.println("Operation Completed Successfully!!");

                    // Remove an existing flight
                } else if (choice.equals("2")) {
                    service.printAvailableIDs();
                    System.out.print("Enter ID of the flight you want to remove: ");
                    String id = scanner.nextLine().toUpperCase();
                    if (!service.remFlight(id)) {
                        System.out.println("No Such ID!!");
                        continue;
                    }
                    System.out.println("Operation Completed Successfully!!");

                    // Modify an existing flight
                } else if (choice.equals("3")) {
                    service.printAvailableFlights();
                    System.out.print("Enter ID of the flight you want to modify: ");
                    String id = scanner.nextLine().toUpperCase();
                    if (!service.printFlight(id)) {
                        System.out.println("No Such ID!!");
                        continue;
                    }

                    // Menu for modifying different aspects of the flight
                    System.out.println("\n1- Change start location\n2- Change destination\n3- Change date\n4- Change time\n5- Cancel");
                    String modifyChoice = scanner.nextLine();
                    while (!modifyChoice.equals("5")) {
                        if (modifyChoice.equals("1")) {
                            // Modify the start location
                            System.out.println("Enter starting location in the form 'City, Country': ");
                            String from = scanner.nextLine();
                            if (!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+", from)) {
                                System.out.println("Invalid Format! Format should be 'City, Country'!!");
                                continue;
                            }
                            Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(from);
                            String fromCity = "", fromCountry = "";
                            if (matcher.find())
                                fromCity = matcher.group().toUpperCase();
                            if (matcher.find())
                                fromCountry = matcher.group().toUpperCase();
                            service.modifyFlightFrom(id, fromCity, fromCountry);
                            System.out.println("Operation Completed Successfully!!");

                        } else if (modifyChoice.equals("2")) {
                            // Modify the destination
                            System.out.println("Enter destination location in the form 'City, Country': ");
                            String to = scanner.nextLine();
                            if (!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+", to)) {
                                System.out.println("Invalid Format! Format should be 'City, Country'!!");
                                continue;
                            }
                            Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(to);
                            String toCity = "", toCountry = "";
                            if (matcher.find())
                                toCity = matcher.group().toUpperCase();
                            if (matcher.find())
                                toCountry = matcher.group().toUpperCase();
                            service.modifyFlightTo(id, toCity, toCountry);
                            System.out.println("Operation Completed Successfully!!");

                        } else if (modifyChoice.equals("3")) {
                            // Modify the flight date
                            System.out.println("Enter date of the flight in the form 'DD.MM.YYYY': ");
                            String date = scanner.nextLine();
                            if (!Pattern.matches("(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(20(2[4-9]|[3-9][0-9]))", date)) {
                                System.out.println("Invalid Input!!");
                                continue;
                            }
                            service.modifyFlightDate(id, date);
                            System.out.println("Operation Completed Successfully!!");

                        } else if (modifyChoice.equals("4")) {
                            // Modify the flight time
                            System.out.println("Enter time of the flight in the form 'HH:MM' (24hr-system): ");
                            String time = scanner.nextLine();
                            while (!Pattern.matches("([0-1][0-9]|2[0-3])\\:([0-5][0-9])", time)) {
                                System.out.println("Invalid Input!!");
                                time = scanner.nextLine();
                            }
                            service.modifyFlightTime(id, time);
                            System.out.println("Operation Completed Successfully!!");

                        } else if (!modifyChoice.equals("5")) {
                            System.out.println("Invalid Choice!");
                        }
                        // Display the modification menu again after each modification
                        System.out.println("\n1- Change start location\n2- Change destination\n3- Change date\n4- Change time\n5- Cancel");
                        modifyChoice = scanner.nextLine();
                    }

                    // Sign out the admin user
                } else if (choice.equals("4")) {
                    user.logout();
                    break;
                }

                // Passenger user operations
            } else if (user.getUserType() == UserType.PASSENGER) {
                System.out.println("\n1- Book Flight\n2- Cancel Booking\n3- Sign out");
                String choice = scanner.nextLine();

                // Book a flight
                if (choice.equals("1")) {
                    System.out.println("1- Domestic Flights\n2- International Flights\n3- Cancel");
                    String type = scanner.nextLine();
                    while (!type.equals("3")) {
                        if (type.equals("1")) {
                            // List available domestic flights and book one
                            service.printAvailableFlights(FlightType.DOMESTIC);
                            System.out.print("Enter ID of the flight you want to book: ");
                            String id = scanner.nextLine().toUpperCase();
                            if (!service.printFlight(id, FlightType.DOMESTIC)) {
                                System.out.println("No Such ID!!");
                                continue;
                            }
                            System.out.println("Enter number of tickets you want to book: ");
                            String tickets = scanner.nextLine();
                            if (!Pattern.matches("\\d+", tickets)) {
                                System.out.println("Invalid Input!!");
                                continue;
                            }
                            int num_tickets = Integer.parseInt(tickets);
                            if (!service.bookFlight(id, (Passenger) user, num_tickets)) {
                                System.out.println("No seats available!!");
                                continue;
                            }
                            System.out.println("Operation Completed Successfully!!");
                            break;
                        } else if (type.equals("2")) {
                            // List available international flights and book one
                            service.printAvailableFlights(FlightType.INTERNATIONAL);
                            System.out.print("Enter ID of the flight you want to book: ");
                            String id = scanner.nextLine().toUpperCase();
                            if (!service.printFlight(id, FlightType.INTERNATIONAL)) {
                                System.out.println("No Such ID!!");
                                continue;
                            }
                            System.out.println("Enter number of tickets you want to book: ");
                            String tickets = scanner.nextLine();
                            if (!Pattern.matches("\\d+", tickets)) {
                                System.out.println("Invalid Input!!");
                                continue;
                            }
                            int num_tickets = Integer.parseInt(tickets);
                            if (!service.bookFlight(id, (Passenger) user, num_tickets)) {
                                System.out.println("No seats available!!");
                                continue;
                            }
                            System.out.println("Operation Completed Successfully!!");
                            break;
                        } else if (!type.equals("3")) {
                            System.out.println("Invalid Choice!!");
                        }
                        // Display the menu again after each selection
                        System.out.println("\n1- Domestic Flights\n2- International Flights\n3- Cancel");
                        type = scanner.nextLine();
                    }

                    // Cancel a booking
                } else if (choice.equals("2")) {
                    if (!user.printFlights()) {
                        System.out.println("No Bookings!!");
                        continue;
                    }
                    System.out.println("Enter ID of the flight you want to cancel: ");
                    String id = scanner.nextLine().toUpperCase();
                    if (!user.getFlightInfo(id)) {
                        System.out.println("No Such ID!!");
                        continue;
                    }
                    System.out.println("Enter number of tickets you want to cancel: ");
                    String tickets = scanner.nextLine();
                    if (!Pattern.matches("\\d+", tickets)) {
                        System.out.println("Invalid Input!!");
                        continue;
                    }
                    int num_tickets = Integer.parseInt(tickets);
                    if (!service.cancelFlight(id, (Passenger) user, num_tickets)) {
                        System.out.println("You didn't purchase that many tickets!!");
                        continue;
                    }
                    System.out.println("Operation Completed Successfully!!");

                    // Sign out the passenger user
                } else if (choice.equals("3")) {
                    user.logout();
                    break;

                } else {
                    System.out.println("Invalid Choice!!");
                }
            }
        }
    }
}
