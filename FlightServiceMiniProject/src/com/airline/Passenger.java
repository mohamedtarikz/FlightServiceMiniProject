package com.airline;

public class Passenger extends SystemUser implements ReserveFlight{

    public Passenger(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.PASSENGER);
    }

    @Override
    public Flight reserveFlight(Flight flight) {
        return null;
    }

}
