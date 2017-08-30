package com.prime.hellorxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.prime.hellorxjava.adapter.StockDataAdapter;
import com.prime.hellorxjava.model.StockUpdate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hello_world_salute)
    TextView helloText;

    @BindView(R.id.stock_updates_recycler_view)
    RecyclerView recyclerView;

    public static final String TAG = MainActivity.class.getSimpleName();
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

        YahooService yahooService = new RetrofitYahooServiceFactory().create();

        String query = "select * from yahoo.finance.quote where symbol in ('YHOO','AAPL','GOOG','MSFT')";;
        String env = "store://datatables.org/alltableswithkeys";

//        yahooService.yqlQuery(query, env)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(data -> log (
//                        data.getQuery().getResults()
//                        .getQuote().get(0).getSymbol()
//                ));

        Observable.interval(0,5, TimeUnit.SECONDS)
                .flatMap(
                        i -> yahooService.yqlQuery(query, env)
                                            .toObservable()
                ).
                subscribeOn(Schedulers.io())
                .map(r -> r.getQuery().getResults().getQuote())
                .flatMap(Observable::fromIterable)
                .map(StockUpdate::create)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stockUpdate -> {
                    Log.d("APP", "New update " + stockUpdate.getStockSymbol());
                    stockDataAdapter.add(stockUpdate);
                });;

//        yahooService.yqlQuery(query, env)
//                .subscribeOn(Schedulers.io())
//                .toObservable()
//                .map(r -> r.getQuery().getResults().getQuote())
//                .flatMap(r -> Observable.fromIterable(r))
//                .map(r -> StockUpdate.create(r))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(stockUpdate -> {
//                    Log.d("APP", "New update " + stockUpdate.getStockSymbol());
//                    stockDataAdapter.add(stockUpdate);
//                });


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
//        Observable.just(
//                new StockUpdate("Google",12.43,new Date()),
//                new StockUpdate("APPLe",645.1, new Date()),
//                new StockUpdate("Twitter",1.43, new Date())
//        ).subscribe(stockDataAdapter::add);

//        Observable.just(
//                new StockUpdate("GOOGLE", 12.43, new Date()),
//                new StockUpdate("APPL", 645.1, new Date()),
//                new StockUpdate("TWTR", 1.43, new Date())
//        ).subscribe( stockUpdate -> {
//            Log.d(TAG,"New update " + stockUpdate.getStockSymbol());
//            stockDataAdapter.add(stockUpdate);
//        });

//        ObservableAll.just("1")
//                .subscribe(e -> Log.d("APP","GOO"+e));
    }

}
