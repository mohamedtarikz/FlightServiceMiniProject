package airline;

import java.util.EventListener;
import java.util.Scanner;

public interface RemoveFlightListener extends EventListener {
    void onRemoveFlight(RemoveFlightEvent event, Admin admin, Scanner scanner);
}
