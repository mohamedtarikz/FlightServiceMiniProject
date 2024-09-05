package airline;

import java.util.EventListener;
import java.util.Scanner;

public interface BookFlightListener extends EventListener{
    void onBookFlight(BookFlightEvent e, Scanner scanner);
}
