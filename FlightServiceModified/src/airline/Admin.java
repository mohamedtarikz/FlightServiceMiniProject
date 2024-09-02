package airline;

public class Admin extends SysUser {
    public Admin(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.ADMIN);
    }

    public void addFlight(Location from, Location to, String date, String time, int seats, double price) {
        if (from.getCountry().equals(to.getCountry())){
            FlightSystem.addFlight(new Flight("D" + (++FlightSystem.num_dom),FlightType.DOMESTIC,seats,price,from,to,date,time));
        }
        else{
            FlightSystem.addFlight(new Flight("I" + (++FlightSystem.num_int),FlightType.INTERNATIONAL,seats,price,from,to,date,time));
        }
    }
    @Override
    public void viewOptions() {
        System.out.println("\nA- Add Flight\nB- Delete Flight\nC- Modify Flight\nD- List Flights\nE- EXIT");
        System.out.print("Please enter your choice: ");
    }
}
