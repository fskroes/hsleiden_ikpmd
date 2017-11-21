package com.fskroes.ikpmd.services;

import com.fskroes.ikpmd.dto.CurrencyDTO;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("ticker/?limit=0") // enter 0 for no limit
    Observable<List<CurrencyDTO>> getListOfCurrenciesConfigurable();

    @GET("ticker/{id}")
    Observable<CurrencyDTO> getSingleCurrencyConfigurable(@Path("id") int id);

    @GET("ticker/{id}/?convert={currencyConverter}")
    Observable<CurrencyDTO> getSingleCurrencyConfigurable(@Path("currencyConverter") String preferredBaseCurrency);
}
