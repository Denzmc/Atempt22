package com.example.attemptnumber22;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Service {

    private String nvidia = "https://api.twelvedata.com/price?symbol=NVDA&apikey=32d961941da54ea0b1206888b9b91f6d";
    private String apple = "https://api.twelvedata.com/price?symbol=AAPL&apikey=32d961941da54ea0b1206888b9b91f6d";
    private String tesla = "https://api.twelvedata.com/price?symbol=TSLA&apikey=32d961941da54ea0b1206888b9b91f6d";
    private String amazon = "https://api.twelvedata.com/price?symbol=AMZN&apikey=32d961941da54ea0b1206888b9b91f6d";

    public Service() throws IOException {
    }

    private static Float quotePrice(String sURL) throws IOException {

        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        JsonParser js = new JsonParser();
        JsonElement root = js.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        String price = rootobj.get("price").getAsString();
        return Float.parseFloat(price);
    }

    public Float getAmazonPrice() {
        return amazonPrice;
    }

    public Float getApplePrice() {
        return applePrice;
    }

    public Float getNvidiaPrice() {
        return nvidiaPrice;
    }

    public Float getTeslaPrice() {
        return teslaPrice;
    }

    Float amazonPrice = quotePrice(amazon);
    Float applePrice = quotePrice(apple);
    Float nvidiaPrice = quotePrice(nvidia);
    Float teslaPrice = quotePrice(tesla);

}
