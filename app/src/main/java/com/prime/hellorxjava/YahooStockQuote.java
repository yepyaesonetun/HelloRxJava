package com.prime.hellorxjava;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by KKT on 8/23/2017.
 **/

public class YahooStockQuote {

    private String symbol;
    @SerializedName("Name")
    private String name;
    @SerializedName("LastTradePriceOnly")
    private double lastTradePriceOnly;
    @SerializedName("DaysLow")
    private BigDecimal daysLow;
    @SerializedName("DaysHigh")
    private BigDecimal daysHigh;
    @SerializedName("Volume")
    private String volume;

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getLastTradePriceOnly() {
        return lastTradePriceOnly;
    }

    public BigDecimal getDaysLow() {
        return daysLow;
    }

    public BigDecimal getDaysHigh() {
        return daysHigh;
    }

    public String getVolume() {
        return volume;
    }
}
