package airline;

import java.util.EventListener;
import java.util.Scanner;

public interface CancelFlightListener extends EventListener {
    void onCancelFlight(CancelFlightEvent event, Scanner scanner);
}
