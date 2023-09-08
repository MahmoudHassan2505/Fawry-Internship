package org.example;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebFilter("/*")
public class LoggingFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Request @" + new Date() + " for " + request.getRequestURL() + " started");
        if (request.getParameter("sessionId") != null) {
            chain.doFilter(request, response);
        } else {
            response.setStatus(403);
            response.getWriter().println("NOT PERMITTED");
        }
        System.out.println("Request @" + new Date() + " for " + request.getRequestURL() + " ended");
    }
}
