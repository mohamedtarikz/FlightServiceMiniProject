package airline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassengerEventsManager {
    // List to keep track of all listeners for booking flights
    private List<BookFlightListener> bookFlightListeners = new ArrayList<BookFlightListener>();

    // Method to add a BookFlightListener to the list
    public void connect_BookFlight(BookFlightListener listener) {
        bookFlightListeners.add(listener);
    }

    // Method to notify all BookFlightListeners about a flight booking event
    public void fireBookFlight(Scanner scanner) {
        // Create a new BookFlightEvent
        BookFlightEvent event = new BookFlightEvent(this);
        // Notify each listener about the booking event
        for (BookFlightListener listener : bookFlightListeners) {
            listener.onBookFlight(event, scanner);
        }
        // Clear the list of listeners after notifying them
        bookFlightListeners.clear();
    }

    // List to keep track of all listeners for canceling flights
    private List<CancelFlightListener> cancelFlightListeners = new ArrayList<CancelFlightListener>();

    // Method to add a CancelFlightListener to the list
    public void connect_CancelFlight(CancelFlightListener listener) {
        cancelFlightListeners.add(listener);
    }

    // Method to notify all CancelFlightListeners about a flight cancellation event
    public void fireCancelFlight(Scanner scanner) {
        // Create a new CancelFlightEvent
        CancelFlightEvent event = new CancelFlightEvent(this);
        // Notify each listener about the cancellation event
        for (CancelFlightListener listener : cancelFlightListeners) {
            listener.onCancelFlight(event, scanner);
        }
        // Clear the list of listeners after notifying them
        cancelFlightListeners.clear();
    }
}
