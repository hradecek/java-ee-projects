package com.hradecek.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
    urlPatterns = {
        "helloWho",
        "helloName",
        "helloFilter"
    }, initParams = {
        @WebInitParam(name = "name", value = "Nobody")
    }
)
public class HelloNameHttpServlet extends HttpServlet {

    private String name;

    @Override
    public void init(ServletConfig config) throws ServletException {
        name = config.getInitParameter("name");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            if (null != request.getParameter("name")) {
                name = request.getParameter("name");
            }

            writer.print("Hello <strong>" + name + "</strong>!");
        }
    }
}
