package airline;

import java.util.EventObject;
public class RemoveFlightEvent extends EventObject {
    public RemoveFlightEvent(Object source) {
        super(source);
    }
}
