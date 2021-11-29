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
import java.util.Objects;

@WebServlet("/tesla")
public class TeslaServlet extends HttpServlet {
    public TeslaServlet() throws IOException {}

    String name;
    String quote = "Tesla";
    User user;
    Service service = new Service();
    Integer available;
    Float price = service.getTeslaPrice();
    Float freeMoney;
    Integer quantity;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("name");
        user = UserDB.readByName(name);
        req.setAttribute("quote", quote);
        req.setAttribute("price" , price);
        available = Math.round(user.getFreeMoney() / price) ;
        req.setAttribute("available", available);
        req.setAttribute("instock", user.getTesla());

        getServletContext().getRequestDispatcher("/buy.jsp").forward(req,resp);
    }
    String buy;
    String sell;
    Integer buyQuantity;
    Integer sellQuantity;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        buy = req.getParameter("buy");
        sell = req.getParameter("sell");
        name = req.getParameter("name");

        buyQuantity = (Objects.equals(buy, "")) ? 0 : Integer.parseInt(buy);

        sellQuantity = (Objects.equals(sell, "")) ? 0 : Integer.parseInt(sell);

        user = UserDB.readByName(name);
        quantity = user.getTesla();
        user.setTesla(quantity + buyQuantity - sellQuantity);
        freeMoney = user.getFreeMoney() - price*user.getTesla();
        user.setFreeMoney(freeMoney);

        UserDB.updateUser(user);

        resp.sendRedirect(req.getContextPath()+"/work?name="+name);
    }
}
