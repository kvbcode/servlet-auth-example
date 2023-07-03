package com.cyber.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.Principal;

@WebServlet(urlPatterns = {"/", "/index.html"}, loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Principal principal = req.getUserPrincipal();
        if (principal != null) {
            req.setAttribute("isLoggedUser", true);
            req.setAttribute("userName", principal.getName());
        } else {
            req.setAttribute("userName", "Anonymous");
        }
        ;
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}
