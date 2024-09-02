package airline;

import java.util.EventObject;
public class ModifyFlightEvent extends EventObject{
    public ModifyFlightEvent(Object source) {
        super(source);
    }
}
