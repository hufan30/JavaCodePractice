package BravoListener;

import java.util.EventObject;

/**
 * 事件抽象基类，后面如果要自定义事件只需要继承此类即可。
 * 这个类没啥深意，source才是真正的事件源，通过BravoApplicationEvent又包装了一层而已
 */
public abstract class BravoApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public BravoApplicationEvent(Object source) {
        super(source);
    }
}
