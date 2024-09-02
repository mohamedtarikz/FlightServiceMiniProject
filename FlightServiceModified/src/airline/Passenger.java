package airline;

public class Passenger extends SysUser{
    public Passenger(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.PASSENGER);
    }

    @Override
    public void viewOptions() {
        System.out.println("\nA- Book Tickets\nB- Cancel Bookings\nC- View Bookings\nD- EXIT");
        System.out.print("Please enter your choice: ");
    }
}
