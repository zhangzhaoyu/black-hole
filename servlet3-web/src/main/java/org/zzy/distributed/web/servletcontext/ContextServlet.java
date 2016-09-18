package org.zzy.distributed.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Created by zhaoyu on 16-8-31.
 */
@WebServlet(
        value = {"/context"}
)
public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        ServletContext context = request.getServletContext();
        readResource(context, writer, "/");
        writer.println(new File("hello.txt").getAbsolutePath());
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void readResource(ServletContext context, PrintWriter writer, String path) {
        Set<String> paths = context.getResourcePaths(path);
        if (paths == null) {
            writer.println("paths is null, path is " + path);
        }
        for (String singlePath : paths) {
            if (singlePath.length() > 1 && singlePath.endsWith("/")) {
                readResource(context, writer, singlePath);
            }
            else {
                writer.println(singlePath);
            }
        }
    }
}
