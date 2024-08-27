package com.airline;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<SystemUser> users = new ArrayList<SystemUser>();

    public UserService(){InitialUsers();}

    private void InitialUsers() {
        this.users.add(new Adminstrator("ahmed","0000"));
        this.users.add(new Adminstrator("gamal","1234"));
        this.users.add(new Passenger("mohamed","5678"));
        this.users.add(new Passenger("lamia","8106"));
        this.users.add(new Passenger("kamal","9876"));
    }
    public List<SystemUser> getUsers() {return this.users;}

    @Override
    public String toString() {return super.toString();}
}
