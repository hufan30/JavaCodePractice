package BravoListener;

/**
 * 下单成功事件，继承自事件抽象基类BravoApplicationEvent
 */
public class OrderSuccessEvent extends BravoApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public OrderSuccessEvent(Object source) {
        super(source);
    }
}
