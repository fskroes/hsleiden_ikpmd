package com.fskroes.ikpmd.models;

import com.fskroes.ikpmd.dto.CurrencyDTO;

public class CurrencyViewModel {
    private CurrencyDTO _currencyDTO;


    private String _currencyName;
    public String getCurrentName() {
        return _currencyName;
    }

    private String _currencyRank;
    public String getCurrencyRank() {
        return _currencyRank;
    }

    private String _currencyID;
    public String getCurrencyID() {
        return _currencyID;
    }

    private final String _currencyUSD;
    public String getCurrencyUSD() {
        return _currencyUSD;
    }

    private final String _currencyBTCValue;
    public String getCurrencyBTCValue() {
        return _currencyBTCValue;
    }

    private final String _currencyMarketCap;
    public String getCurrencyMarketCap() { return _currencyMarketCap; }

    private final String _currencyPercentageChange1h;
    public String getCurrencyPercentageChange1h() { return _currencyPercentageChange1h; }

    private final String _currencyPercentageChange24h;
    public String getCurrencyPercentageChange24h() { return _currencyPercentageChange24h; }

    private final String _currencyPercentageChange7d;
    public String getCurrencyPercentageChange7d() { return _currencyPercentageChange7d; }

    public CurrencyViewModel(CurrencyDTO currencyDTO) {
        this._currencyDTO = currencyDTO;

        _currencyID = _currencyDTO.getId();
        _currencyName = _currencyDTO.getName();
        _currencyRank = _currencyDTO.getRank();
        _currencyUSD = _currencyDTO.getPriceUsd();
        _currencyBTCValue = currencyDTO.getPriceBtc();
        _currencyMarketCap = currencyDTO.getMarketCapUsd();
        _currencyPercentageChange1h = currencyDTO.getPercentChange1h();
        _currencyPercentageChange24h = currencyDTO.getPercentChange24h();
        _currencyPercentageChange7d = currencyDTO.getPercentChange7d();
    }


}
