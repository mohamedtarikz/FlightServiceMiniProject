package com.airline;

public abstract class SystemUser {
    private String username;
    private String password;
    private UserType userType;

    public static SystemUser login(String username, String password, UserService service) {

        SystemUser systemUser = null;
        for(SystemUser user : service.getUsers()) {
            if (user.username.equals(username) && user.password.equals(password)) {
                systemUser = user;
                break;
            }
        }

        return systemUser;
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public UserType getUserType() {return userType;}
    public void setUserType(UserType userType) {this.userType = userType;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
}
