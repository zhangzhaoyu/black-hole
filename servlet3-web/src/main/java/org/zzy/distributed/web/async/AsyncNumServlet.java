package org.zzy.distributed.web.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * Created by zhaoyu on 16-9-1.
 */
@WebServlet(
        value = "/asyncNum",
        asyncSupported = true
)
public class AsyncNumServlet extends HttpServlet {

    private Vector<AsyncContext> asyncContexts;

    @Override
    public void init() throws ServletException {
        asyncContexts = (Vector<AsyncContext>) getServletContext().getAttribute("asyncs");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext context = req.startAsync();
        synchronized (asyncContexts) {
                asyncContexts.add(context);
        }
    }
}
