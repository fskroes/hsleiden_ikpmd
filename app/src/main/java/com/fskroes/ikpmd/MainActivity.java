package com.fskroes.ikpmd;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fskroes.ikpmd.adapters.CurrencyListViewAdapter;
import com.fskroes.ikpmd.dto.CurrencyDTO;
import com.fskroes.ikpmd.models.CurrencyViewModel;
import com.fskroes.ikpmd.services.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable;

    @BindView(R.id.my_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        compositeDisposable = new CompositeDisposable();
        initRecyclerView();
        initJsonReponse();
    }

    private void initJsonReponse() {
        ApiService apiService = new Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);

        apiService.getListOfCurrenciesConfigurable()
                .flatMapIterable(list -> list)
                .map(item -> new CurrencyViewModel(item))
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError);
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            initJsonReponse();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    private void handleError(Throwable throwable) {
        if (swipeRefreshLayout.isEnabled()) swipeRefreshLayout.setEnabled(false);
        System.out.println("error: " + throwable.getMessage());
    }

    private void handleResponse(List<CurrencyViewModel> currencyViewModels) {
        List<CurrencyViewModel> list = new ArrayList<>(currencyViewModels);
        adapter = new CurrencyListViewAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
