package airline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassengerEventsManager {
    private List<BookFlightListener> bookFlightListeners = new ArrayList<BookFlightListener>();
    public void connect_BookFlight(BookFlightListener listener) {
        bookFlightListeners.add(listener);
    }
    public void fireBookFlight(Scanner scanner){
        BookFlightEvent event = new BookFlightEvent(this);
        for(BookFlightListener listener : bookFlightListeners){
            listener.onBookFlight(event, scanner);
        }
        bookFlightListeners.clear();
    }

    private List<CancelFlightListener> cancelFlightListeners = new ArrayList<CancelFlightListener>();
    public void connect_CancelFlight(CancelFlightListener listener){
        cancelFlightListeners.add(listener);
    }
    public void fireCancelFlight(Scanner scanner){
        CancelFlightEvent event = new CancelFlightEvent(this);
        for(CancelFlightListener listener : cancelFlightListeners){
            listener.onCancelFlight(event, scanner);
        }
        cancelFlightListeners.clear();
    }
}
