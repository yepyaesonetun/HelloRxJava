package com.prime.hellorxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.prime.hellorxjava.adapter.StockDataAdapter;
import com.prime.hellorxjava.model.StockUpdate;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hello_world_salute)
    TextView helloText;

    @BindView(R.id.stock_updates_recycler_view)
    RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;
    private StockDataAdapter stockDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        stockDataAdapter = new StockDataAdapter();
        recyclerView.setAdapter(stockDataAdapter);

//        ObservableAll.just("Hello! Please use this app responsibly!")
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        helloText.setText(s);
//                    }
//                });

        /** Using Retrolambra with Java 8 feature.**/
        Observable.just("Please use this app responsibility.")
                .subscribe(s -> helloText.setText(s));

//        ObservableAll.just("Apple","Google","Twitter")
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String stockSymbol) throws Exception {
//                        stockDataAdapter.add(stockSymbol);
//                    }
//                });


//        ObservableAll.just(
//                new StockUpdate("Google",12.43,new Date()),
//                new StockUpdate("APPLe",645.1, new Date()),
//                new StockUpdate("Twitter",1.43, new Date())
//
//        ).subscribe(new Consumer<StockUpdate>() {
//            @Override
//            public void accept(StockUpdate stockUpdate) throws Exception {
//                stockDataAdapter.add(stockUpdate);
//            }
//        });

        /** Using Retrolambra with Java 8 feature.**/
        Observable.just(
                new StockUpdate("Google",12.43,new Date()),
                new StockUpdate("APPLe",645.1, new Date()),
                new StockUpdate("Twitter",1.43, new Date())
        ).subscribe(stockDataAdapter::add);

//        ObservableAll.just("1")
//                .subscribe(e -> Log.d("APP","GOO"+e));
    }
}
