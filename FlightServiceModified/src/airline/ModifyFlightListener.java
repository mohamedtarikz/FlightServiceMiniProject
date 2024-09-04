package airline;

import java.util.EventListener;
import java.util.Scanner;

public interface ModifyFlightListener extends EventListener {
    void onModifyFlight(ModifyFlightEvent event, Admin admin, Scanner scanner);
}
