package com.example.attemptnumber22.servlets;

import com.example.attemptnumber22.User;
import com.example.attemptnumber22.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    String name;
    String password;
    String confirmPassword;
    String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        name = req.getParameter("username");
        password = req.getParameter("pass");
        confirmPassword = req.getParameter("cpass");

        if (!password.equals(confirmPassword)){
            message = "Пароль не подтвержден";
            return;
        }
        if (UserDB.readByName(name) != null ) {
            message = "Пользователь с таким именем уже существует";
        } else {
            User user = new User(name, password);
            UserDB.saveUser(user);
            resp.sendRedirect(req.getContextPath()+"/hello-servlet");
        }
    }
}
