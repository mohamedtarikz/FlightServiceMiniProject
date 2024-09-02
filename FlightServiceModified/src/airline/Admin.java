package airline;

public class Admin extends SysUser {
    public Admin(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.ADMIN);
    }

    @Override
    public void viewOptions() {
        System.out.println("\nA- Add Flight\nB- Delete Flight\nC- Modify Flight\nD- List Flights\nE- EXIT");
        System.out.print("Please enter your choice: ");
    }
}
