package com.fskroes.ikpmd.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fskroes.ikpmd.R;
import com.fskroes.ikpmd.dto.CurrencyDTO;
import com.fskroes.ikpmd.models.CurrencyViewModel;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

public class CurrencyListViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

    private final PublishSubject<CurrencyViewModel> onClickSubject = PublishSubject.create();
    private List<CurrencyViewModel> values;

    // Provide a suitable constructor (depends on the kind of dataset)
    public CurrencyListViewAdapter(List<CurrencyViewModel> models) {
        values = models;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_item_card, parent, false);
        // set the view's size, margins, paddings and layout parameters
        RecycleViewHolder vh = new RecycleViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecycleViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = values.get(position).getCurrentName();
        holder.nameTextView.setText(name);
        holder.rankTextView.setText(values.get(position).getCurrencyRank());
        holder.usdTextView.setText("USD : " + values.get(position).get_currencyUSD());

        CurrencyViewModel element = values.get(holder.getLayoutPosition());

        holder.layout.setOnClickListener(view -> {
            onClickSubject.onNext(element);
            System.out.println(element.getCurrentName());
        });
    }

    public PublishSubject<CurrencyViewModel> getOnClickSubject() {
        return onClickSubject;
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
