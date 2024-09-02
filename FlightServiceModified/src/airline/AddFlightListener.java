package airline;

import java.util.EventListener;
import java.util.Scanner;

public interface AddFlightListener extends EventListener{
    void onAddFlight(AddFlightEvent e, Admin admin, Scanner scanner);
}
