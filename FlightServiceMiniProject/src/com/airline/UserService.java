package com.airline;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<SystemUser> users = new ArrayList<SystemUser>();

    public UserService(){InitialUsers();}

    private void InitialUsers() {
        this.users.add(new Adminstrator("Ahmed","0000"));
        this.users.add(new Adminstrator("Gamal","1234"));
        this.users.add(new Passenger("Mohamed","5678"));
        this.users.add(new Passenger("Lamia","8106"));
        this.users.add(new Passenger("Kamal","9876"));
    }
    public List<SystemUser> getUsers() {return this.users;}

}
