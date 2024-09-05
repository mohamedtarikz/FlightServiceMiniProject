package airline;

import java.util.EventObject;
public class CancelFlightEvent extends EventObject {
    public CancelFlightEvent(Object source) {
        super(source);
    }
}
