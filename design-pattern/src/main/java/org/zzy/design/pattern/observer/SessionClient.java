package org.zzy.design.pattern.observer;

/**
 * Created by zhaoyu on 16-8-30.
 */
public class SessionClient {
    public static void main(String[] args) {
        SessionSubject sessionSubject = new SessionSubject();
        Observer observer = new SessionObserver();
        sessionSubject.addObserver(observer);

        sessionSubject.changeSessionId("sessionID");
        sessionSubject.addAttribute("zhang", "zhangzhaoyu");
    }
}
