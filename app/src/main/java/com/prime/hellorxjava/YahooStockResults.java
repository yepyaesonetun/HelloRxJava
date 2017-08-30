package com.prime.hellorxjava;

import java.util.List;

/**
 * Created by KKT on 8/23/2017.
 **/

class YahooStockResults {

    private YahooStockQuery query;
    private List<YahooStockQuote> quote;

    public YahooStockQuery getQuery() {
        return query;
    }

    public List<YahooStockQuote> getQuote() {
        return quote;
    }
}
