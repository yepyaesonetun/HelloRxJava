package com.prime.hellorxjava.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prime.hellorxjava.R;
import com.prime.hellorxjava.model.StockUpdate;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SantaClaus on 11/08/2017.
 **/

public class StockDataAdapter extends RecyclerView.Adapter<StockDataAdapter.StockUpdateViewHolder> {

    private final List<StockUpdate> data = new ArrayList<>();

    @Override
    public StockUpdateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_update_item, parent, false);
        return new StockUpdateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StockUpdateViewHolder holder, int position) {
        StockUpdate stockUpdate = data.get(position);
        holder.setStockSymbol(stockUpdate.getStockSymbol());
        holder.setPrice(stockUpdate.getPrice());
        holder.setDate(stockUpdate.getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void add(StockUpdate stockSymbol){
        this.data.add(stockSymbol);
        notifyItemInserted(data.size() - 1);
    }

    class StockUpdateViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.stock_item_symbol)
        TextView stockSymbol;

        @BindView(R.id.stock_item_date)
        TextView date;

        @BindView(R.id.stock_item_price)
        TextView price;

        private final NumberFormat PRICE_FORMAT = new DecimalFormat("#0.00");

        public void setStockSymbol(String stockSymbol){
            this.stockSymbol.setText(stockSymbol);
        }

        public void setPrice(double price){
            this.price.setText(PRICE_FORMAT.format(price));
        }

        public void setDate(Date date){
            this.date.setText(android.text.format.DateFormat.format("yyyy-MM-dd hh:mm",date));
        }


        public StockUpdateViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
