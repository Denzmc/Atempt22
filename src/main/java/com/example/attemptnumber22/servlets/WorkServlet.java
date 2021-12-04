package com.example.attemptnumber22.servlets;

import com.example.attemptnumber22.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@WebServlet("/work")
public class WorkServlet extends HttpServlet {
    private final String twelvedata = "https://api.twelvedata.com/price?symbol=";
    //degtayr
    private final String apikey = "&apikey=32d961941da54ea0b1206888b9b91f6d";
    //morockesh
//    private final String apikey = "&apikey=81339aa99b934358ba4e0480fba5619b";
    List<Stock> stocks;

    private String name;
    private User user;

    private Float freeMoney;
    private Float allMoney;
    private Float amazonMoney;
    private Float appleMoney;
    private Float nvidiaMoney;
    private Float teslaMoney;
    private Float difference;

    @Override
    public void init() {
        stocks = StockDB.getAllStocks();
        for (Stock stock: stocks ) {
            try {
                Float price = stockPrice(twelvedata + stock.getNameStock() + apikey);
                if (price != null){
                    stock.setPriceStock(price);
                    StockDB.updateStock(stock);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("stocks", stocks);

        name = req.getParameter("name");

        user = UserDB.readByName(name);

        req.setAttribute("user", user);
        //ошибка
        difference = user.getFreeMoney() + user.getAmazon() + user.getApple() + user.getNvidia() + user.getTesla();

        req.setAttribute("totaldiff", difference);

        getServletContext().getRequestDispatcher("/work.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init();
        doGet(req, resp);
    }

    private Float stockPrice(String sURL) throws IOException {

        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        JsonParser js = new JsonParser();
        JsonElement root = js.parse(new InputStreamReader((InputStream) request.getContent()));
        if (root != null) {
            JsonObject rootobj = root.getAsJsonObject();
            String price = rootobj.get("price").getAsString();
            return Float.parseFloat(price);
        }
        return null;
    }
}
