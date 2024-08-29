import com.airline.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FlightReservationService service = new FlightReservationService();

        UserService userService = new UserService();

        String username, pass;
        System.out.print("Please enter your username: ");
        username = scanner.nextLine().toLowerCase(Locale.ENGLISH);
        System.out.print("Please enter your password: ");
        pass = scanner.nextLine();

        SystemUser user = SystemUser.login(username, pass, userService);
        if (user != null) {
            System.out.println("You have successfully logged in " + user.getUsername() + "!");
        } else
            System.out.println("Wrong Credentials!");
        while (user != null) {
            if (user.getUserType() == UserType.ADMIN) {
                System.out.println("\n1- Add Flight\n2- Remove Flight\n3- Modify Flight\n4- Sign out");
                String choice;
                choice = scanner.nextLine();
                if (choice.equals("1")) {
                    System.out.println("Enter starting location in the form 'City, Country': ");
                    String from = scanner.nextLine();
                    if(!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+",from)){
                        System.out.println("Invalid Format! Format should be 'City, Country'!!");
                        continue;
                    }
                    Pattern pattern = Pattern.compile("[a-zA-Z]+");
                    Matcher matcher = pattern.matcher(from);
                    String fromCity = "", fromCountry = "";
                    if(matcher.find())
                        fromCity = matcher.group().toUpperCase();
                    if(matcher.find())
                        fromCountry = matcher.group().toUpperCase();
                    System.out.println("Enter destination location in the form 'City, Country': ");
                    String to = scanner.nextLine();
                    if(!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+",to)){
                        System.out.println("Invalid Format! Format should be 'City, Country'!!");
                        continue;
                    }
                    matcher = pattern.matcher(to);
                    String toCity = "", toCountry = "";
                    if(matcher.find())
                        toCity = matcher.group().toUpperCase();
                    if(matcher.find())
                        toCountry = matcher.group().toUpperCase();
                    System.out.println("Enter date of the flight in the form 'DD.MM.YYYY': ");
                    String date = scanner.nextLine();
                    while(!Pattern.matches("(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(20(2[4-9]|[3-9][0-9]))",date)){
                        System.out.println("Invalid Input!!");
                        date = scanner.nextLine();
                    }
                    System.out.println("Enter time of the flight in the form 'HH:MM' (24hr-system): ");
                    String time = scanner.nextLine();
                    while(!Pattern.matches("([0-1][0-9]|2[0-3])\\:([0-5][0-9])",time)){
                        System.out.println("Invalid Input!!");
                        time = scanner.nextLine();
                    }
                    if(fromCountry.equals(toCountry)){
                        service.addFlight(new Flight("D"+ Integer.toString(++FlightReservationService.num_dom),FlightType.DOMESTIC,new Location(fromCity,fromCountry),new Location(toCity,toCountry),date,time));
                    }
                    else{
                        service.addFlight(new Flight("I"+ Integer.toString(++FlightReservationService.num_int),FlightType.INTERNATIONAL,new Location(fromCity,fromCountry),new Location(toCity,toCountry),date,time));
                    }
                    System.out.println("Operation Completed Successfully!!");
                } else if(choice.equals("2")){
                    service.printAvailableIDs();
                    System.out.print("Enter ID of the flight you want to remove: ");
                    String id = scanner.nextLine();
                    if(!service.remFlight(id)){
                        System.out.println("No Such ID!!");
                        continue;
                    }
                    System.out.println("Operation Completed Successfully!!");
                } else if (choice.equals("3")) {
                    service.printAvailableFlights();
                    System.out.print("Enter ID of the flight you want to modify: ");
                    String id = scanner.nextLine();
                    if(!service.printFlight(id)){
                        System.out.println("No Such ID!!");
                        continue;
                    }
                    System.out.println("\n1- Change start location\n2- Change destination\n3- Change date\n4- Change time\n5- Cancel");
                    String modifyChoice = scanner.nextLine();
                    while(!modifyChoice.equals("5")) {
                        if (modifyChoice.equals("1")) {
                            System.out.println("Enter starting location in the form 'City, Country': ");
                            String from = scanner.nextLine();
                            if (!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+", from)) {
                                System.out.println("Invalid Format! Format should be 'City, Country'!!");
                                continue;
                            }
                            Pattern pattern = Pattern.compile("[a-zA-Z]+");
                            Matcher matcher = pattern.matcher(from);
                            String fromCity = "", fromCountry = "";
                            if (matcher.find())
                                fromCity = matcher.group().toUpperCase();
                            if (matcher.find())
                                fromCountry = matcher.group().toUpperCase();
                            service.modifyFlightFrom(id, fromCity, fromCountry);
                            System.out.println("Operation Completed Successfully!!");
                        } else if (modifyChoice.equals("2")) {
                            System.out.println("Enter destination location in the form 'City, Country': ");
                            String to = scanner.nextLine();
                            if (!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+", to)) {
                                System.out.println("Invalid Format! Format should be 'City, Country'!!");
                                continue;
                            }
                            Pattern pattern = Pattern.compile("[a-zA-Z]+");
                            Matcher matcher = pattern.matcher(to);
                            String toCity = "", toCountry = "";
                            if (matcher.find())
                                toCity = matcher.group().toUpperCase();
                            if (matcher.find())
                                toCountry = matcher.group().toUpperCase();
                            service.modifyFlightTo(id, toCity, toCountry);
                            System.out.println("Operation Completed Successfully!!");
                        } else if (modifyChoice.equals("3")) {
                            System.out.println("Enter date of the flight in the form 'DD.MM.YYYY': ");
                            String date = scanner.nextLine();
                            if (!Pattern.matches("(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(20(2[4-9]|[3-9][0-9]))", date)) {
                                System.out.println("Invalid Input!!");
                                continue;
                            }
                            service.modifyFlightDate(id, date);
                            System.out.println("Operation Completed Successfully!!");
                        } else if (modifyChoice.equals("4")) {
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
                        System.out.println("\n1- Change start location\n2- Change destination\n3- Change date\n4- Change time\n5- Cancel");
                        modifyChoice = scanner.nextLine();
                    }
                } else if (choice.equals("4")) {
                    user.logout();
                    break;
                }
            } else if (user.getUserType() == UserType.PASSENGER) {

            }
        }
    }
}