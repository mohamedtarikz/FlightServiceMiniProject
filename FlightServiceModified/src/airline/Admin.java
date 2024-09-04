package airline;

import java.util.Scanner;

public class Admin extends SysUser implements AddFlightListener,RemoveFlightListener,ModifyFlightListener{
    AdminInputSystem adminInputSystem = new AdminInputSystem();

    public Admin(String name, String pass) {
        this.setUsername(name);
        this.setPassword(pass);
        this.setUserType(UserType.ADMIN);
    }
    @Override
    public void onAddFlight(AddFlightEvent event, Scanner scanner) {
        adminInputSystem.onAddFlight(scanner);
    }
    @Override
    public void onRemoveFlight(RemoveFlightEvent event, Scanner scanner) {
        adminInputSystem.onRemoveFlight(scanner);
    }
    @Override
    public void onModifyFlight(ModifyFlightEvent event, Scanner scanner) {
        adminInputSystem.onModifyFlight(scanner);
    }
}
