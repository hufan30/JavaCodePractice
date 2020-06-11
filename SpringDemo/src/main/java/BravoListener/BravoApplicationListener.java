package BravoListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 监听器接口，监听事件抽象基类的所有子类对象
 *
 * @param <E>
 */
public interface BravoApplicationListener<E extends BravoApplicationEvent> {

    /**
     * 当监听器监听到对应的事件发布时，会回调本方法
     *
     * @param event
     */
    void onApplicationEvent(E event);

    /**
     * 当前监听器是否匹配本次事件
     *
     * @param event
     * @param applicationListener
     * @return
     */
    default boolean supportsEventType(BravoApplicationEvent event, BravoApplicationListener applicationListener) {
        Type[] genericInterfaces = applicationListener.getClass().getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            Class eventClass = (Class) ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
            if (eventClass.equals(event.getClass())) {
                return true;
            }
        }
        return false;
    }

}
