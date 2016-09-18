package org.zzy.distributed.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhaoyu on 16-8-29.
 */
@WebServlet(value = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PrintWriter writer = resp.getWriter();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                writer.println("path:" + cookie.getPath());
                writer.println("domain:" + cookie.getDomain());
                writer.println("version:" + cookie.getVersion());
                writer.println(cookie.getName() + "\t\t" + cookie.getValue());
            }

            Cookie cookie = new Cookie("zhang", "zhaoyu");
            resp.addCookie(cookie);
        }

    }
}
