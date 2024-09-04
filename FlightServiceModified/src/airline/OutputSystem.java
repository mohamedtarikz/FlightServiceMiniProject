package airline;

public class OutputSystem {
    public static void printFlights(){
        System.out.println("====================Domestic flights====================");
        for (Flight flight: FlightSystem.getFlights(FlightType.DOMESTIC)){
            System.out.print(flight);
        }
        System.out.println("====================International flights====================");
        for (Flight flight: FlightSystem.getFlights(FlightType.INTERNATIONAL)){
            System.out.print(flight);
        }
    }
    public static void printFlights(FlightType type){
        if(type == FlightType.DOMESTIC) {
            System.out.println("====================Domestic flights====================");
            for (Flight flight: FlightSystem.getFlights(FlightType.DOMESTIC)){
                System.out.print(flight);
            }
        }
        else if(type == FlightType.INTERNATIONAL) {
            System.out.println("====================International flights====================");
            for (Flight flight: FlightSystem.getFlights(FlightType.INTERNATIONAL)){
                System.out.print(flight);
            }
        }
    }
    public static boolean printFlight(String flightID){
        Flight flight = FlightSystem.getFlight(flightID);
        if (flight != null){
            System.out.println(flight);
            return true;
        }
        return false;
    }

    public static void viewOptions(UserType userType){
        if(userType == UserType.ADMIN) {
            System.out.println("\nA- Add Flight\nB- Delete Flight\nC- Modify Flight\nD- List Flights\nE- EXIT");
            System.out.print("Please enter your choice: ");
        } else if (userType == UserType.PASSENGER) {
            System.out.println("\nA- Book Tickets\nB- Cancel Bookings\nC- View Bookings\nD- EXIT");
            System.out.print("Please enter your choice: ");
        }
    }
}
