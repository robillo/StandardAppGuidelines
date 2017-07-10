package com.appbusters.robinkamboj.standardappguidelines;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolderMain extends RecyclerView.ViewHolder {

    public TextView text1, text2;
    public CardView cardView;

    public ViewHolderMain(View itemView) {
        super(itemView);
        text1 = (TextView) itemView.findViewById(R.id.text1);
        text2 = (TextView) itemView.findViewById(R.id.text2);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
    }
}
