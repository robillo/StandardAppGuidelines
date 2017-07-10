package com.appbusters.robinkamboj.standardappguidelines;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AdapterMain extends RecyclerView.Adapter<ViewHolderMain> {

    private List<ModelMain> list = new ArrayList<>();
    private Context context, parentContext;
    private boolean[] isSelected;
    private int pos;

    public AdapterMain(List<ModelMain> list, Context context) {
        this.list = list;
        this.context = context;
        isSelected = new boolean[list.size()];
    }

    @Override
    public ViewHolderMain onCreateViewHolder(ViewGroup parent, int viewType) {
        parentContext = parent.getContext();
        for(int i = 0; i<list.size(); i++){
            isSelected[i] = false;
        }
        View v = LayoutInflater.from(parentContext).inflate(R.layout.row_layout, parent, false);
        return new ViewHolderMain(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolderMain holder, final int position) {
        pos = position;
        holder.text1.setText(list.get(pos).getText1());
        holder.text2.setText(list.get(pos).getText2());
        if(isSelected[position]){
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }
        else {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelected[pos]){
                    holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));
                    isSelected[pos] = false;
                }
                else {
                    holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                    isSelected[pos] = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
