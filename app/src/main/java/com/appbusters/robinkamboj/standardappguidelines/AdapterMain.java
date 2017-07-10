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

    public AdapterMain(List<ModelMain> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolderMain onCreateViewHolder(ViewGroup parent, int viewType) {
        parentContext = parent.getContext();
        View v = LayoutInflater.from(parentContext).inflate(R.layout.row_layout, parent, false);
        return new ViewHolderMain(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderMain holder, int position) {
        holder.text1.setText(list.get(position).getText1());
        holder.text2.setText(list.get(position).getText2());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
