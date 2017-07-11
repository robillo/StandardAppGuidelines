package com.appbusters.robinkamboj.standardappguidelines;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

class AdapterMain extends RecyclerView.Adapter<ViewHolderMain> {

    List<ModelMain> list = new ArrayList<>();
    private Context context;
    private ArrayList<Boolean> isSelected;

    AdapterMain(List<ModelMain> list, Context context, ArrayList<Boolean> isSelected) {
        this.list = list;
        this.context = context;
        this.isSelected = isSelected;
    }

    @Override
    public ViewHolderMain onCreateViewHolder(ViewGroup parent, int viewType) {
        Context parentContext = parent.getContext();
        View v = LayoutInflater.from(parentContext).inflate(R.layout.row_layout, parent, false);
        return new ViewHolderMain(v);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBindViewHolder(final ViewHolderMain holder, final int position) {
        holder.text1.setText(list.get(position).getText1());
        holder.text2.setText(list.get(position).getText2());
        if(isSelected.get(position)){
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }
        else {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelected.get(position)){
                    holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));
                    isSelected.set(position, false);
                }
                else {
                    holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                    isSelected.set(position, true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    ArrayList<Boolean> getIsSelected() {
        return isSelected;
    }
}
