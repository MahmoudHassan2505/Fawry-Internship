package org.example;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class MyListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest httpRequest = (HttpServletRequest) sre.getServletRequest();
        System.out.println("Request initlaized " + httpRequest.getRequestURL());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest httpRequest = (HttpServletRequest) sre.getServletRequest();
        System.out.println("Request destroyed " + httpRequest.getRequestURL());
    }
}
