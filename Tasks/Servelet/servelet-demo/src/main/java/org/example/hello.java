package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;

@WebServlet("/hello")
public class hello extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("I'm In INITIAL METHOD");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Do Get Helooooo");
        String name = request.getParameter("name");
        response.getWriter().println("Hello <b>"+name+"</b>");
        response.setStatus(201);
        response.setContentType("text/html");
        response.getWriter().println("<img src='img.jpg'/>");
        response.getWriter().println("<hr />");
        response.getWriter().println("Copyright (c)");
    }

    @Override
    public void destroy() {
        System.out.println("I'm In destroy METHOD");
    }
}
