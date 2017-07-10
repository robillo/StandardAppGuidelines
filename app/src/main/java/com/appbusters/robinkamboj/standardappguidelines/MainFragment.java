package com.appbusters.robinkamboj.standardappguidelines;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        selectedItems = (Button) v.findViewById(R.id.selected);

        for(int i=0; i<30; i++){
            list.add(new ModelMain("Text One " + i, "Text Two " + i));
        }

        adapter = new AdapterMain(list, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return v;
    }

}
