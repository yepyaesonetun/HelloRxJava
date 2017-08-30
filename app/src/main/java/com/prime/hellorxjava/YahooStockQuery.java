package com.prime.hellorxjava;

import java.util.Date;

/**
 * Created by KKT on 8/23/2017.
 **/

public class YahooStockQuery {
    private int count;
    private Date created;
    private YahooStockResults results;

    public int getCount() {
        return count;
    }

    public Date getCreated() {
        return created;
    }

    public YahooStockResults getResults() {
        return results;
    }
}
