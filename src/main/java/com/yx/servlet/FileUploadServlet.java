package com.yx.servlet;

/**
 * User: NMY
 * Date: 16-8-29
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/servlet/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Part part = req.getPart("upload");
        String disposition = part.getHeader("content-disposition");
        String fileName = disposition.substring(disposition.lastIndexOf("=") + 2, disposition.length() - 1);
        String uploadPath = req.getServletContext().getRealPath("/upload");
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        part.write(uploadPath + File.separator + fileName);
        resp.getOutputStream().print("upload success!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(403);
    }
}
