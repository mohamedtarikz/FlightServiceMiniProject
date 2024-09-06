package airline;

public abstract class SysUser {
    protected String username;
    protected String password;
    protected UserType userType;

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

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

}
