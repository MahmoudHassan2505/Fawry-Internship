package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        System.out.println("HelloServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet doGet");
        String name = request.getParameter("name");


        response.setStatus(201);
        response.setContentType(MediaType.TEXT_HTML);
        response.setHeader("my-test-header", "test-value");
        response.getWriter().println("Helloooooooooooooooooooooooo ya <b>" + name + "</b>");
        response.getWriter().println("<img src='fawry.png' />");
        response.getWriter().println("<hr />");
        response.getWriter().println("copyright (c)");
    }


    @Override
    public void destroy() {
        System.out.println("HelloServlet destroy");
    }
}
