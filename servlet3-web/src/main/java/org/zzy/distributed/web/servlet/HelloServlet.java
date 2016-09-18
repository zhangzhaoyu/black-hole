package org.zzy.distributed.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by zhaoyu on 16-8-26.
 */
@WebServlet(value = "/hello.view")
public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("Hello Servlet Constructor!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("other").include(request, response);

        PrintWriter writer = response.getWriter();
        writer.println("getCharacterEncoding" + "\t\t" +request.getCharacterEncoding());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            writer.println(name + "\t\t" + request.getHeader(name));
        }
        writer.close();
    }

    @Override
    public void destroy() {
        System.out.println("Hello Servlet destroy!!");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Hello Servlet init!!");
    }
}
