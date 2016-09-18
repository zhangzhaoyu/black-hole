package org.zzy.distributed.web.fitler;

import org.zzy.distributed.web.wrapper.CompressionWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhaoyu on 16-8-31.
 */
public class CompressionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String encoding = req.getHeader("accept-encoding");
        if (encoding != null && (encoding.indexOf("gzip") > -1)) {
            CompressionWrapper wrapper = new CompressionWrapper(resp);
            wrapper.setHeader("content-encoding", "gzip");

            chain.doFilter(request, response);

            GZIPOutputStream gzipOutputStream = wrapper.getGZIPOutputStream();
            if (gzipOutputStream != null) {
                gzipOutputStream.finish();
            }
        }
        else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
