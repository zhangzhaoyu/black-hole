package org.zzy.distributed.web.listener;

import javax.servlet.http.*;

/**
 * Created by zhaoyu on 16-8-29.
 */
public class HelloSessionListener implements HttpSessionListener,
        HttpSessionActivationListener, HttpSessionBindingListener,
        HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {

    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {

    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
