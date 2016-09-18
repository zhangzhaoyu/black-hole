package org.zzy.distributed.web.async;

import org.springframework.core.task.support.ExecutorServiceAdapter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoyu on 16-9-1.
 */
@WebServlet(
        name = "asyncServlet",
        urlPatterns = "/async",
        asyncSupported = true
)
public class AsyncServlet extends HttpServlet {

    private ExecutorService executorService =
            Executors.newFixedThreadPool(10);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        AsyncContext context = req.startAsync();
        executorService.submit(new AsyncRequest(context));
    }

    @Override
    public void destroy() {
        super.destroy();
        executorService.shutdown();
    }
}

class AsyncRequest implements Runnable {

    private AsyncContext context;

    public AsyncRequest(AsyncContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            PrintWriter writer = context.getResponse().getWriter();
            writer.println("waite so long, XD.");
            context.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
