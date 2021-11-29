package com.example.attemptnumber22.servlets;

import com.example.attemptnumber22.Service;
import com.example.attemptnumber22.User;
import com.example.attemptnumber22.UserDB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work")
public class WorkServlet extends HttpServlet {

    public WorkServlet() throws IOException {}

    Service s = new Service();
    String name;
    User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("amazon", s.getAmazonPrice());
        req.setAttribute("apple", s.getApplePrice());
        req.setAttribute("nvidia", s.getNvidiaPrice());
        req.setAttribute("tesla", s.getTeslaPrice());

        name = req.getParameter("name");
        req.setAttribute("name", name);

        user = UserDB.readByName(name);

        req.setAttribute("total", user.getAllMoney());
        req.setAttribute("balance", user.getFreeMoney());
        req.setAttribute("amquan", user.getAmazon());
        req.setAttribute("apquan", user.getApple());
        req.setAttribute("nvquan", user.getNvidia());
        req.setAttribute("tequan", user.getTesla());

        getServletContext().getRequestDispatcher("/work.jsp").forward(req, resp);
    }
    Float freeMoney;
    Float allMoney;
    Float amazonMoney;
    Float appleMoney;
    Float nvidiaMoney;
    Float teslaMoney;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        amazonMoney = user.getAmazon()*s.getAmazonPrice();
        appleMoney = user.getApple()*s.getApplePrice();
        nvidiaMoney = user.getNvidia()*s.getNvidiaPrice();
        teslaMoney = user.getTesla()*s.getTeslaPrice();

        freeMoney = user.getFreeMoney();
        allMoney = freeMoney + amazonMoney + appleMoney + nvidiaMoney + teslaMoney;
        user.setAllMoney(allMoney);
        UserDB.updateUser(user);
        doGet(req, resp);
    }
}
