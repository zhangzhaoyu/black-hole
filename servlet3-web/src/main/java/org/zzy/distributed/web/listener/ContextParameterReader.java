package org.zzy.distributed.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by zhaoyu on 16-8-31.
 */
@WebListener
public class ContextParameterReader implements ServletContextListener {

    public ContextParameterReader() {
        System.out.println("ContextParameterReader Constructor.");
    }

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        ServletContext context = contextEvent.getServletContext();
        String avatars = context.getInitParameter("AVATAR");
        context.setAttribute("avatars", avatars);
        System.out.println("contextInitialized avatars : " + avatars);
    }

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {

    }
}
