package com.airline;

import java.util.*;

public abstract class SystemUser {
    private String username;
    private String password;
    private UserType userType;


    public static SystemUser login(String username, String password, UserService service) {
        SystemUser systemUser = null;
        for(SystemUser user : service.getUsers()) {
            if (user.username.toLowerCase().equals(username) && user.password.equals(password)) {
                systemUser = user;
                break;
            }
        }

        return systemUser;
    }

    public void logout(){
        System.out.println("Good Bye!");
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public UserType getUserType() {return userType;}
    public void setUserType(UserType userType) {this.userType = userType;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public boolean printFlights(){
        return false;
    }

    public boolean getFlightInfo(String id){
        return false;
    }
    @Override
    public String toString() {
        return username;
    }
}
