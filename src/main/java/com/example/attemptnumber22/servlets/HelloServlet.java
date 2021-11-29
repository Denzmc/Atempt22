package com.example.attemptnumber22.servlets;

import com.example.attemptnumber22.User;
import com.example.attemptnumber22.UserDB;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    String name;
    String password;
    String message = "Failed!";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out =response.getWriter();

        List<User> users = UserDB.getAllUsers();
        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

//        User user = new User("Mikel","root");
//
//        UserDB.saveUser(user);

//        User user2 = UserDB.readById(3);
//        user2.setAmazon(26);
//        user2.setTesla(51);
//        UserDB.updateUser(user2);

//        User user1 = UserDB.readByName(user.getName());
//        user1.setApple(67);
//        user1.setNvidia(58);
//        UserDB.updateUser(user1);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        name = req.getParameter("username");
        password = req.getParameter("pass");
        User user = UserDB.readByName(name);

        if (user != null && user.getPassword().equals(password))
            resp.sendRedirect(req.getContextPath()+"/work?name="+name);
        else {
            req.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}