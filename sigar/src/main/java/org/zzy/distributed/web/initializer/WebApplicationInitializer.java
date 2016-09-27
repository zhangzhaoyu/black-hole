package org.zzy.distributed.web.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by zhaoyu on 16-8-24.
 */
public interface WebApplicationInitializer {

    void onStartup(ServletContext servletContext) throws ServletException;

}
