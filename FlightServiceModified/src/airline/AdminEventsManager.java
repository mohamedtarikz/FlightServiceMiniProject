package airline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminEventsManager {
    private List<AddFlightListener> addFlightListeners = new ArrayList<AddFlightListener>();
    public void add_AddFlight_Listener(AddFlightListener listener) {
        addFlightListeners.add(listener);
    }
    public void remove_AddFlight_Listener(AddFlightListener listener) {
        addFlightListeners.remove(listener);
    }
    public void fireAddFlight(Scanner scanner) {
        AddFlightEvent event = new AddFlightEvent(this);
        for (AddFlightListener listener : addFlightListeners){
            listener.onAddFlight(event, scanner);
        }
        addFlightListeners.clear();
    }

    private List<RemoveFlightListener> removeFlightListeners = new ArrayList<RemoveFlightListener>();
    public void add_RemoveFlight_Listener(RemoveFlightListener listener) {
        removeFlightListeners.add(listener);
    }
    public void remove_RemoveFlight_Listener(RemoveFlightListener listener) {
        removeFlightListeners.remove(listener);
    }
    public void fireRemoveFlight(Scanner scanner) {
        RemoveFlightEvent event = new RemoveFlightEvent(this);
        for (RemoveFlightListener listener : removeFlightListeners) {
            listener.onRemoveFlight(event, scanner);
        }
        removeFlightListeners.clear();
    }

    private List<ModifyFlightListener> modifyFlightListeners = new ArrayList<ModifyFlightListener>();
    public void add_ModifyFlight_Listener(ModifyFlightListener listener) {
        modifyFlightListeners.add(listener);
    }
    public void remove_ModifyFlight_Listener(ModifyFlightListener listener) {
        modifyFlightListeners.remove(listener);
    }
    public void fireModifyFlight(Scanner scanner) {
        ModifyFlightEvent event = new ModifyFlightEvent(this);
        for (ModifyFlightListener listener : modifyFlightListeners) {
            listener.onModifyFlight(event, scanner);
        }
        modifyFlightListeners.clear();
    }
}
