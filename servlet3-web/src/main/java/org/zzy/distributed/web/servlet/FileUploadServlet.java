package org.zzy.distributed.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by zhaoyu on 16-8-29.
 */
@MultipartConfig(location = "/home/zhaoyu/fileupload")
@WebServlet(value = "/upload")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Part part  = req.getPart("photo");
        System.out.println("getSubmittedFileName " + part.getSubmittedFileName());
        Collection<String> collection = part.getHeaderNames();
        for (String header : collection) {
            System.out.println(header + "\t\t" + part.getHeader(header));
        }

        part.write(part.getSubmittedFileName());
        resp.getWriter().write("upload success!!!");
    }

    private String getSubmittedFileName(Part part) {
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(
                header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\"")
        );
        return fileName;
    }
}
