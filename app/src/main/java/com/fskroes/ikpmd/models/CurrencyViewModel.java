package com.fskroes.ikpmd.models;

import android.support.v7.widget.RecyclerView;

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

    public CurrencyViewModel(CurrencyDTO currencyDTO) {
        this._currencyDTO = currencyDTO;

        _currencyID = _currencyDTO.getId();
        _currencyName = _currencyDTO.getName();
        _currencyRank = _currencyDTO.getRank();
    }
}
