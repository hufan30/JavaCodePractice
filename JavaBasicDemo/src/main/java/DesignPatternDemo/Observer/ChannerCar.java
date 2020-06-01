package DesignPatternDemo.Observer;

import java.util.*;

/**
 * @author hufan
 * @date 2020/5/31 7:56 下午
 * @annotation 用于描述观察者模式，又称为发布订阅模式；
 */
public class ChannerCar {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        Car c1 = new Car(1, eventBus);
        Car c2 = new Car(2, eventBus);
        Radio radio = new Radio(eventBus);
        c1.turnOnRadio("交通广播");
        c2.turnOnRadio("交通广播");
        radio.outputMessage("交通广播", "下午堵车");

    }
}

class Radio {
    EventBus eventBus;

    public Radio(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    /**
     * 这里开始体现，监听器和观察者模式了；
     * 之前一直纠结的是为什么监听器能够知道那些事件发生了，监听器主动一直轮询去监听，太低效了；
     * 实际的做法就应该是这样有一个中间件，然后事件发生后触发publish；
     * @param channel
     * @param message
     */
    public void outputMessage(String channel, String message) {
        eventBus.publish(channel, message);
    }
}

/**
 * 目前也有一种说法，说这个是被包装后的监听器对象；
 * 某种程度上也有道理，因为EventBus里面维护的map或者其他；
 * 反正都是listener，无需维护radio；
 */
class EventBus {
    Map<String, List<Listener>> listMap = new HashMap<>();

    /**
     * 订阅的函数
     * @param channel
     * @param listener
     */
    public void subscribe(String channel, Listener listener) {
        List<Listener> listenerList = listMap.getOrDefault(channel, new ArrayList<>());
        listenerList.add(listener);
        listMap.put(channel, listenerList);
    }

    public void publish(String channel, String message) {
        listMap.getOrDefault(channel, Collections.emptyList()).forEach(listener -> listener.listenMessage(message));
    }
}

interface Listener {
    void listenMessage(String message);
}

class Car implements Listener {
    int id;
    EventBus eventBus;

    public Car(int id, EventBus eventBus) {
        this.id = id;
        this.eventBus = eventBus;
    }

    public void turnOnRadio(String channel) {
        eventBus.subscribe(channel, this);
    }

    @Override
    public void listenMessage(String message) {
        System.out.println(id + ":" + message);
    }
}