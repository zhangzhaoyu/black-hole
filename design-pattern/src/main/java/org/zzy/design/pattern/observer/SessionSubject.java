package org.zzy.design.pattern.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyu on 16-8-30.
 */
public class SessionSubject extends Subject {

    private String id;
    private Map<String, Object> data = new HashMap<>();

    public SessionSubject() {
    }

    public void changeSessionId(String sessionId) {
        this.id = sessionId;
        notifyObservers(this, null);
    }

    public void addAttribute(String key, Object value) {
        this.data.put(key, value);
        notifyObservers(this, null);
    }

    public String getId() {
        return id;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
