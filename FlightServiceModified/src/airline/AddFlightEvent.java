package airline;

import java.util.EventObject;
public class AddFlightEvent extends EventObject{
    public AddFlightEvent(Object source) {
        super(source);
    }
}
