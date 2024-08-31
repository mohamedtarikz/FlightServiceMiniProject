package com.airline;

public class Adminstrator extends SystemUser {


    public Adminstrator(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.ADMIN);
    }

    @Override
    public String toString() {
        return "Administrator [Username = " + getUsername() + ", Password = " + getPassword() +  "]" ;
    }
}
