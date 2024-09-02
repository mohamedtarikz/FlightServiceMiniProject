package airline;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<SysUser> users = new ArrayList<SysUser>();

    private void initialize() {
        users.add(new Admin("Mohamed", "8106"));
        users.add(new Admin("Ali", "1111"));
        users.add(new Passenger("Ahmed", "2222"));
        users.add(new Passenger("Mohamed", "0000"));
        users.add(new Passenger("Gamal", "4444"));
    }

    public UserService(){
        initialize();
    }

    public List<SysUser> getUsers(){return users;}
}
