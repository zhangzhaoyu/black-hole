package org.zzy.design.pattern.observer.event;

import java.util.EventObject;

/**
 * Created by zhaoyu on 16-8-31.
 */
public class Event extends EventObject {

    private static final long serialVersionUID = 2808077614876552093L;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public Event(Object source) {
        super(source);
    }

}
