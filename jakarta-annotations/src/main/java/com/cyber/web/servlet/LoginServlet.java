package com.cyber.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getUserPrincipal() != null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("j_username");
        String password = req.getParameter("j_password");

        try {
            req.login(userName, password);
        } catch (ServletException ex) {
            req.setAttribute("error_message", ex.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/error/login_error.jsp").forward(req, resp);
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
