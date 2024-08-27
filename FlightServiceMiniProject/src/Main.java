import com.airline.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FlightReservationService service = new FlightReservationService();

        while(true) {
            UserService userService = new UserService();

            String username, pass;
            System.out.print("Please enter your username: ");
            username = scanner.nextLine();
            System.out.print("Please enter your password: ");
            pass = scanner.nextLine();

            SystemUser user = SystemUser.login(username, pass, userService);
            if (user != null) {
                System.out.println("You have successfully logged in " + user.getUsername() + "!");
                if(user.getUserType() == UserType.ADMIN){
                    System.out.println("1- Add Flight\n2- Remove Flight\n3- Modify Flight");
                    String choice;
                    choice = scanner.nextLine();
                    if(choice.equals("1")){

                    }
                }
                else{

                }
            }else
                System.out.println("Wrong Credentials!");
        }
    }

}