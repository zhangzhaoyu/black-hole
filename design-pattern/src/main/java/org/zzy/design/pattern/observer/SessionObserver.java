package org.zzy.design.pattern.observer;

/**
 * Created by zhaoyu on 16-8-30.
 */
public class SessionObserver implements Observer {
    @Override
    public void update(Subject subject, Object object) {
        SessionSubject sessionSubject = (SessionSubject) subject;
        System.out.println(sessionSubject.getData());
        System.out.println(sessionSubject.getId());
    }
}
