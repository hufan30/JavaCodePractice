package BravoListener;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/**
 * 默认的广播器，如果需要自定义，可以自己实现BravoApplicationEventMulticaster或者继承本类后重写
 */
public class BravoSimpleApplicationEventMuiltcaster implements BravoApplicationEventMulticaster{

    /**
     * 监听器。广播器里收集了所有实现了BravoApplicationListener接口的listener。
     * 本案例中SmsService实现了该接口，也是一个监听器。
     */
    public final Set<BravoApplicationListener<?>> applicationListeners = new LinkedHashSet<>();

    /**
     * 线程池接口，默认是null。
     * 如果希望事件执行变为异步的，可以在外部调用setTaskExecutor设置一个Executor进来
     * 详情请参考：
     * {@link com.bravo.event.BravoSimpleApplicationEventMuiltcaster#multicastEvent(BravoApplicationEvent)}
     */
    private Executor taskExecutor;

    public void setTaskExecutor(Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }


    protected Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    @Override
    public void addApplicationListener(BravoApplicationListener<?> listener) {
        applicationListeners.add(listener);
    }

    /**
     * 遍历所有监听器，找到当前事件匹配的监听器，并调用监听器的回调方法
     * @param event
     */
    @Override
    public void multicastEvent(final BravoApplicationEvent event) {
        for (final BravoApplicationListener<?> listener : getApplicationListeners(event)) {
            Executor executor = getTaskExecutor();
            // excutor不为空，则开启异步线程完成方法回调
            if (executor != null) {
                executor.execute(() -> invokeListener(listener, event));
            }
            else {
                invokeListener(listener, event);
            }
        }
    }

    /**
     * 假设传进来的是OrderSuccessEvent，而此时容器中有两个监听器：
     * SmsService implements BravoApplicationListener<OrderSuccessEvent>   ====>  监听OrderSuccessEvent
     * CarService implements BravoApplicationListener<OtherEvent>   ====>  监听OtherEvent
     *
     * 那么，我们必须从两个监听器中筛选出匹配的监听器
     *
     * @param event
     * @return
     */
    public Collection<BravoApplicationListener<?>> getApplicationListeners(BravoApplicationEvent event) {
        Set<BravoApplicationListener<?>> matchedListener = new LinkedHashSet<>();
        for (BravoApplicationListener<?> applicationListener : this.applicationListeners) {
            if (applicationListener.supportsEventType(event, applicationListener)) {
                matchedListener.add(applicationListener);
            }
        }
        return matchedListener;
    }

    /**
     * 执行监听器回调方法 onApplicationEvent(event)
     * @param listener
     * @param event
     */
    protected void invokeListener(BravoApplicationListener listener, BravoApplicationEvent event) {
        listener.onApplicationEvent(event);
    }


}
