package org.zzy.distributed.web.fitler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by zhaoyu on 16-8-31.
 */
public class PerformanceFilter implements Filter {

    private FilterConfig config;

    public PerformanceFilter() {
        System.out.println(PerformanceFilter.this.getClass().getName() + " Constructor.");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("Request process in " + (System.currentTimeMillis() - begin) + " milliseconds.");
    }

    @Override
    public void destroy() {

    }
}
