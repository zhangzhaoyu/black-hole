package org.zzy.distributed.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhaoyu on 16-8-30.
 */
public class XmlConfigServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        String xmlName = getServletConfig().getInitParameter("xmlName");
        System.out.println(xmlName);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("XmlConfigServlet.");
        String xmlName = getInitParameter("xmlName");
        writer.println(xmlName);
        writer.close();
    }

    @Override
    public void destroy() {

    }
}
