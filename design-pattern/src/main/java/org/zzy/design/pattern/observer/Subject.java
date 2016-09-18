package org.zzy.design.pattern.observer;

import java.util.Vector;

/**
 * Created by zhaoyu on 16-8-30.
 */
public abstract class Subject {

    private Vector<Observer> observers = new Vector<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    public void notifyObservers(Subject subject, Object object) {
        for (Observer observer : observers) {
            observer.update(subject, object);
        }
    }
}
