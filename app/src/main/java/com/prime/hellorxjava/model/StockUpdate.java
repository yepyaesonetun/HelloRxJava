package com.prime.hellorxjava.model;

import com.prime.hellorxjava.YahooService;
import com.prime.hellorxjava.YahooStockQuote;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SantaClaus on 11/08/2017.
 **/

public class StockUpdate implements Serializable {

    private final String stockSymbol;
    private final double price;
    private final Date date;

    public StockUpdate(String stockSymbol, double price, Date date) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.date = date;
    }

    public static StockUpdate create(YahooStockQuote r){
        return  new StockUpdate(r.getSymbol(), r.getLastTradePriceOnly(),
                new Date());
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}
