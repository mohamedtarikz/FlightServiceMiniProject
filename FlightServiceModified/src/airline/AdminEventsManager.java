package airline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminEventsManager {

    // List to store listeners for adding flights
    private List<AddFlightListener> addFlightListeners = new ArrayList<AddFlightListener>();

    // Method to connect/register an AddFlightListener
    public void connect_AddFlight(AddFlightListener listener) {
        addFlightListeners.add(listener);  // Add listener to the list
    }

    // Method to trigger the add flight event
    public void fireAddFlight(Scanner scanner) {
        // Create an AddFlightEvent
        AddFlightEvent event = new AddFlightEvent(this);

        // Notify all listeners about the event
        for (AddFlightListener listener : addFlightListeners) {
            listener.onAddFlight(event, scanner);  // Call the listener's onAddFlight method
        }

        // Clear listeners after the event has been processed
        addFlightListeners.clear();
    }

    // List to store listeners for removing flights
    private List<RemoveFlightListener> removeFlightListeners = new ArrayList<RemoveFlightListener>();

    // Method to connect/register a RemoveFlightListener
    public void connect_RemoveFlight(RemoveFlightListener listener) {
        removeFlightListeners.add(listener);  // Add listener to the list
    }

    // Method to trigger the remove flight event
    public void fireRemoveFlight(Scanner scanner) {
        // Create a RemoveFlightEvent
        RemoveFlightEvent event = new RemoveFlightEvent(this);

        // Notify all listeners about the event
        for (RemoveFlightListener listener : removeFlightListeners) {
            listener.onRemoveFlight(event, scanner);  // Call the listener's onRemoveFlight method
        }

        // Clear listeners after the event has been processed
        removeFlightListeners.clear();
    }

    // List to store listeners for modifying flights
    private List<ModifyFlightListener> modifyFlightListeners = new ArrayList<ModifyFlightListener>();

    // Method to connect/register a ModifyFlightListener
    public void connect_ModifyFlight(ModifyFlightListener listener) {
        modifyFlightListeners.add(listener);  // Add listener to the list
    }

    // Method to trigger the modify flight event
    public void fireModifyFlight(Scanner scanner) {
        // Create a ModifyFlightEvent
        ModifyFlightEvent event = new ModifyFlightEvent(this);

        // Notify all listeners about the event
        for (ModifyFlightListener listener : modifyFlightListeners) {
            listener.onModifyFlight(event, scanner);  // Call the listener's onModifyFlight method
        }

        // Clear listeners after the event has been processed
        modifyFlightListeners.clear();
    }
}
