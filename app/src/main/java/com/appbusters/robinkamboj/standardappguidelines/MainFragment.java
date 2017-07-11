package com.appbusters.robinkamboj.standardappguidelines;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    AdapterMain adapter;
    Button selectedItems;
    List<ModelMain> list = new ArrayList<>();
    boolean[] mSelectedItems;
    ArrayList<Boolean> isSelected = new ArrayList<>();

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i=0; i<30; i++){
            list.add(new ModelMain("Text One " + i, "Text Two " + i));
        }
        for(int i = 0; i<list.size(); i++){
            isSelected.add(false);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        selectedItems = (Button) v.findViewById(R.id.selected);

        adapter = new AdapterMain(list, getActivity(), isSelected);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mSelectedItems = new boolean[adapter.getIsSelected().size()];
         for(int i=0; i<adapter.getIsSelected().size(); i++){
             mSelectedItems[i] = adapter.getIsSelected().get(i);
         }
        outState.putBooleanArray("selected_items", mSelectedItems);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            mSelectedItems = savedInstanceState.getBooleanArray("selected_items");

            for(int i = 0; i<list.size(); i++){
                isSelected.add(mSelectedItems[i]);
            }
        }
    }
}
