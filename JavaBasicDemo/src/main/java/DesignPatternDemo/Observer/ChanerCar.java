package DesignPatternDemo.Observer;

import java.util.*;

/**
 * @author hufan
 * @date 2020/5/31 7:56 下午
 * @annotation 用于描述观察者模式，又称为发布订阅模式；
 */
public class ChanerCar {
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

    public void outputMessage(String channel, String message) {
        eventBus.publish(channel, message);
    }
}

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