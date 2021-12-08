package com.example.attemptnumber22.servlets;

import com.example.attemptnumber22.Stock;
import com.example.attemptnumber22.StockDB;
import com.example.attemptnumber22.User;
import com.example.attemptnumber22.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {

    String userName;
    String stockName;
    User user;
    Stock stock;
    Float price;
    Float freeMoney;
    Integer quantity;
    Integer available;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userName = req.getParameter("name");
        user = UserDB.readByName(userName);
        stockName = req.getParameter("stock");
        stock = StockDB.readByName(stockName);
        price = stock.getPriceStock();

        req.setAttribute("quote", stockName);
        req.setAttribute("price" , price);

        available = (int) Math.floor(user.getFreeMoney() / price) ;

        req.setAttribute("available", available);
        req.setAttribute("instock", getStockQuantity(user,stockName));

        getServletContext().getRequestDispatcher("/buy.jsp").forward(req,resp);
    }
    String buy;
    String sell;
    Integer buyQuantity;
    Integer sellQuantity;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        buy = req.getParameter("buy");
        sell = req.getParameter("sell");

        buyQuantity = (Objects.equals(buy, "")) ? 0 : Integer.parseInt(buy);

        sellQuantity = (Objects.equals(sell, "")) ? 0 : Integer.parseInt(sell);

        quantity = getStockQuantity(user, stockName);
        //mistake

        int transaction = quantity + buyQuantity - sellQuantity;
        setQuantity(user,stockName, transaction);

        freeMoney = user.getFreeMoney() - price*(buyQuantity - sellQuantity);
        user.setFreeMoney(freeMoney);

        UserDB.updateUser(user);

        resp.sendRedirect(req.getContextPath()+"/work?name="+userName);
    }

    private int getStockQuantity(User user, String stockName){
        int quantity = 0;
        switch (stockName){
            case "AMZN": quantity = user.getAmazon();
                break;
            case "AAPL": quantity = user.getApple();
                break;
            case "NVDA": quantity = user.getNvidia();
                break;
            case "TSLA": quantity = user.getTesla();
                break;
        }

        return  quantity;
    }
    private void setQuantity(User user, String stockName, int quantity){
        switch (stockName){
            case "AMZN": user.setAmazon(quantity);
                break;
            case "AAPL": user.setApple(quantity);
                break;
            case "NVDA": user.setNvidia(quantity);
                break;
            case "TSLA": user.setTesla(quantity);
                break;
        }
    }
}
