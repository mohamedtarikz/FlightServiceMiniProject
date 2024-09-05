package airline;

import java.util.EventObject;
public class BookFlightEvent extends EventObject {
    public BookFlightEvent(Object source) {
        super(source);
    }
}
