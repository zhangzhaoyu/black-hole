package org.zzy.design.pattern.observer.event;

import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaoyu on 16-8-31.
 */
public class EventSourceObject {

    private String name;
    private Set<EatEventListener> listeners = new HashSet<>();

    public EventSourceObject() {
        this.name = "default";
    }

    public EventSourceObject(String name, Set<EatEventListener> listeners) {
        this.name = name;
        this.listeners = listeners;
    }

    public void addListener(EatEventListener listener) {
        this.listeners.add(listener);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void notifyAllListener() {
        for (EatEventListener object : listeners) {
            object.fireEvent(new Event(this));
        }
    }

}
