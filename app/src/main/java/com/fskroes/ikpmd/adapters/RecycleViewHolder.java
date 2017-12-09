package com.fskroes.ikpmd.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.fskroes.ikpmd.R;

public class RecycleViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTextView;
    public TextView rankTextView;
    public TextView usdTextView;
    public View layout;

    public RecycleViewHolder(View itemView) {
        super(itemView);

//        itemView.setOnClickListener(view -> {
//            Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
//            intent.putExtra()
//            itemView.getContext().startActivity(intent);
//        });

        layout = itemView;
        nameTextView = itemView.findViewById(R.id.currencyName);
        rankTextView = itemView.findViewById(R.id.currencyRank);
        usdTextView = itemView.findViewById(R.id.currencyValue);
    }
}
