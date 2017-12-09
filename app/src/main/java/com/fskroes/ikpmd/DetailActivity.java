package com.fskroes.ikpmd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fskroes.ikpmd.models.CurrencyViewModel;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.currencyName)
    TextView textViewName;
    @BindView(R.id.currencyUSD)
    TextView textViewUSD;
    @BindView(R.id.currencyBTC)
    TextView textViewBTC;
    @BindView(R.id.currencyMarketCap)
    TextView textViewMarketCap;
    @BindView(R.id.currencyRank)
    TextView textViewRank;
    @BindView(R.id.currencyPercentageChange1h)
    TextView textViewP1h;
    @BindView(R.id.currencyPercentageChange24h)
    TextView textViewP24h;
    @BindView(R.id.currencyPercentageChange7d)
    TextView textViewP7d;

    private CurrencyViewModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);

        model = new Gson()
                .fromJson((String) getIntent().getSerializableExtra("element"),
                        CurrencyViewModel.class);

        initValues();
    }

    private void initValues() {
        textViewName.setText("Currency: " + model.getCurrentName());
        textViewUSD.setText("USD: " + model.getCurrencyUSD());
        textViewBTC.setText("BTC: " + model.getCurrencyBTCValue());
        textViewMarketCap.setText("MarketCap: " + model.getCurrencyMarketCap());
        textViewRank.setText("Rank: " + model.getCurrencyRank());
        textViewP1h.setText("1h %: " + model.getCurrencyPercentageChange1h());
        textViewP24h.setText("24h %: " + model.getCurrencyPercentageChange24h());
        textViewP7d.setText("7d %: " + model.getCurrencyPercentageChange7d());
    }
}
