package com.prime.hellorxjava.model;

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
