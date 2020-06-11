package BravoListener;

/**
 * 事件广播器接口
 */
public interface BravoApplicationEventMulticaster {

    /**
     * 往广播器中添加listener
     * @param listener
     */
    void addApplicationListener(BravoApplicationListener<?> listener);

    /**
     * 发布事件
     * @param event
     */
    void multicastEvent(BravoApplicationEvent event);

}
