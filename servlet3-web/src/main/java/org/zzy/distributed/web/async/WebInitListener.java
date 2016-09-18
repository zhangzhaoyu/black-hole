package org.zzy.distributed.web.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by zhaoyu on 16-9-1.
 */
@WebListener
public class WebInitListener implements ServletContextListener {

    private Vector<AsyncContext> asyncContextList = new Vector<>();

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        sce.getServletContext().setAttribute("asyncs", asyncContextList);
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        int time = (int) (Math.random() * 10000);
                        System.out.println("---------------" + time);
                        Thread.sleep(time);

                        synchronized (asyncContextList) {
                            for (AsyncContext asyncContext : asyncContextList) {
                                PrintWriter writer = asyncContext.getResponse().getWriter();
                                double num = Math.random() * 10;
                                writer.println(num);
                                asyncContext.complete();
                            }
                            asyncContextList.removeAllElements();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
