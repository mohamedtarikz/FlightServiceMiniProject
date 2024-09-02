package airline;

public abstract class SysUser {
    private String username;
    private String password;
    private UserType userType;

    public static SysUser login(String username, String password, UserService userService) {
        for (SysUser user : userService.getUsers()) {
            if(user.getUsername().toLowerCase().equals(username.toLowerCase()) && user.getPassword().equals(password)) {
                System.out.println("Welcome, " + user.getUsername() + "!");
                System.out.println("Signed in as " + user.getUserType());
                return user;
            }
        }
        System.out.println("Invalid username or password!");
        return null;
    }

    public String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    protected void setUserType(UserType userType) {
        this.userType = userType;
    }

    public abstract void viewOptions();
}
