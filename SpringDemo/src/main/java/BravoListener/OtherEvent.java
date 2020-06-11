package BravoListener;

/**
 * @author bravo
 * @date 2020-02-09 18:10
 */
public class OtherEvent extends BravoApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public OtherEvent(Object source) {
        super(source);
    }
}
