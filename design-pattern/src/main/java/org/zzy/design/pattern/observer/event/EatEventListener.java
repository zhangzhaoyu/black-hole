package org.zzy.design.pattern.observer.event;

import java.util.EventListener;

/**
 * Created by zhaoyu on 16-8-31.
 */
public class EatEventListener implements EventListener {

    public void fireEvent(Event event) {
        System.out.println(event.getSource());
    }

}
