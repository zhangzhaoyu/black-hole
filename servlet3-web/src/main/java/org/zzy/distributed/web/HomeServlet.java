package org.zzy.distributed.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by zhaoyu on 16-8-23.
 */
@WebServlet(value = "/home/*")
public class HomeServlet extends HttpServlet {

    public HomeServlet() {
        System.out.println("servlet init!!!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello World!!!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30);

        response.getWriter().println("Hello World!!!");
        PrintWriter writer = response.getWriter();

        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            writer.println(header + " \t\t" + request.getHeader(header));
        }

        writer.println("authtype" + "\t\t" + request.getAuthType());
        writer.println("requestURI" + "\t\t" + request.getRequestURI());
        writer.println("getContextPath" + "\t\t" + request.getContextPath());
        writer.println("servletPath" + "\t\t" + request.getServletPath());
        writer.println("getPathInfo" + "\t\t" + request.getPathInfo());
        writer.println("getMethod" + "\t\t" + request.getMethod());
        writer.println("getLocalAddr" + "\t\t" + request.getLocalAddr());
        writer.println("getPathTranslated"+ "\t\t" + request.getPathTranslated());
        writer.println("getQueryString" + "\t\t" + request.getQueryString());
        writer.println("getRequestURI" + "\t\t" + request.getRequestURI());
        writer.println("getRequestURL" + "\t\t" + request.getRequestURL());
        writer.println("" + "\t\t");
        writer.close();
    }
}
