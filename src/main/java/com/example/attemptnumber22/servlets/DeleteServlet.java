package com.example.attemptnumber22.servlets;

import com.example.attemptnumber22.User;
import com.example.attemptnumber22.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        User user = UserDB.readByName(name);
        UserDB.deleteUser(user);
        resp.sendRedirect(req.getContextPath()+"/hello");
    }
}
