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
        while (true) {
            if (user.getUserType() == UserType.ADMIN) {
                System.out.println("1- Add Flight\n2- Remove Flight\n3- Modify Flight");
                String choice;
                choice = scanner.nextLine();
                if (choice.equals("1")) {
                    System.out.println("Enter starting location in the form 'City, Country': ");
                    String from = scanner.nextLine();
                    if(!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+",from)){
                        System.out.println("Invalid Format! Format should be 'City, Country'!!");
                        continue;
                    }
                    Pattern pattern = Pattern.compile("[a-zA-z]+");
                    Matcher matcher = pattern.matcher(from);
                    String fromCity = "", fromCountry = "";
                    if(matcher.find())
                        fromCity = matcher.group();
                    if(matcher.find())
                        fromCountry = matcher.group();
                    System.out.println("Enter destination location in the form 'City, Country': ");
                    String to = scanner.nextLine();
                    if(!Pattern.matches("[a-zA-Z]+[\\,][\\s]*[a-zA-Z]+",to)){
                        System.out.println("Invalid Format! Format should be 'City, Country'!!");
                        continue;
                    }
                    matcher = pattern.matcher(to);
                    String toCity = "", toCountry = "";
                    if(matcher.find())
                        toCity = matcher.group();
                    if(matcher.find())
                        toCountry = matcher.group();
                    System.out.println("Enter date of the flight in the form 'DD.MM.YYYY': ");
                    String date = scanner.nextLine();
                    while(!Pattern.matches("(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(20(2[4-9]|[3-9][0-9]))",date)){
                        System.out.println("Invalid Input!!");
                        date = scanner.nextLine();
                    }
                    System.out.println("Enter date of the flight in the form 'HH:MM' (24hr-system): ");
                    String time = scanner.nextLine();
                    while(!Pattern.matches("([0-1][0-9]|2[0-3])\\:([0-5][0-9])",time)){
                        System.out.println("Invalid Input!!");
                        time = scanner.nextLine();
                    }
                    if(fromCountry.equals(toCountry)){
                        service.addFlight(new Flight(FlightType.DOMESTIC,new Location(fromCity,fromCountry),new Location(toCity,toCountry),date,time));
                    }
                    else{
                        service.addFlight(new Flight(FlightType.INTERNATIONAL,new Location(fromCity,fromCountry),new Location(toCity,toCountry),date,time));
                    }
                } else {
                    continue;
                }
            }
        }
    }
}