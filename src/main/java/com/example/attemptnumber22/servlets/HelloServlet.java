package com.example.attemptnumber22.servlets;

import com.example.attemptnumber22.User;
import com.example.attemptnumber22.UserDB;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private String message = "Fail!";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<User> users = UserDB.getAllUsers();
        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");
        String pass = req.getParameter("pass");
        User user = UserDB.readByName(name);

        if (user != null && user.getPassword().equals(pass))
            resp.sendRedirect(req.getContextPath()+"/work?name="+ name);
        else {
            req.setAttribute("message", message);
            doGet(req, resp);
        }
    }
}