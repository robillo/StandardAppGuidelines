package com.appbusters.robinkamboj.standardappguidelines;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    AdapterMain adapter;
    Button selectView;
    List<ModelMain> list = new ArrayList<>();
    boolean[] mSelectedItems;
    ArrayList<Boolean> isSelected = new ArrayList<>();
    private static boolean isShowingDialog = false;
    AlertDialog.Builder builder;
    AlertDialog dialog;

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        builder = new AlertDialog.Builder(getActivity());
        for(int i=0; i<30; i++){
            list.add(new ModelMain("Text One " + i, "Text Two " + i));
        }
        for(int i = 0; i<list.size(); i++){
            isSelected.add(false);
        }
        Log.e("ONCREATE", "CALLED");
        Log.e("ISSHOWING DIALOG", String.valueOf(isShowingDialog));
        if(dialog!=null && isShowingDialog && !dialog.isShowing()){
            showDialog();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        selectView = (Button) v.findViewById(R.id.selected);

        adapter = new AdapterMain(list, getActivity(), isSelected);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        selectView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        return v;
    }

    private void showDialog(){
        final String[] temp = {"Words: "};
        for(int i=0; i<list.size(); i++){
            if(isSelected.get(i)){
                temp[0] = temp[0].concat(adapter.list.get(i).getText1());
            }
        }
        isShowingDialog = true;
        builder.setTitle("Selected Items:")
                .setMessage(temp[0])
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        isShowingDialog = false;
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Nope", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        isShowingDialog = false;
                        dialog.dismiss();
                    }
                });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
//                isShowingDialog = false;
                Log.e("DISMISS DIALOG LISTENER", "CALLED");
            }
        });
        dialog = builder.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("ONDESTROY", "CALLED");
        Log.e("ISSHOWING DIALOG", String.valueOf(isShowingDialog));
        if(dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("ONSTOP", "CALLED");
        Log.e("ISSHOWING DIALOG", String.valueOf(isShowingDialog));
        if(dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("ONPAUSE", "CALLED");
        Log.e("ISSHOWING DIALOG", String.valueOf(isShowingDialog));
        if(dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("ONRESUME", "CALLED");
        Log.e("ISSHOWING DIALOG", String.valueOf(isShowingDialog));
        if(dialog!=null && isShowingDialog && !dialog.isShowing()){
            showDialog();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("ONSTART", "CALLED");
        Log.e("ISSHOWING DIALOG", String.valueOf(isShowingDialog));
        if(dialog!=null && isShowingDialog && !dialog.isShowing()){
            showDialog();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mSelectedItems = new boolean[adapter.getIsSelected().size()];
         for(int i=0; i<adapter.getIsSelected().size(); i++){
             mSelectedItems[i] = adapter.getIsSelected().get(i);
         }
        outState.putBooleanArray("selected_items", mSelectedItems);
        outState.putBoolean("is_showing_dialog", isShowingDialog);
        super.onSaveInstanceState(outState);
    }



    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            mSelectedItems = savedInstanceState.getBooleanArray("selected_items");
            isShowingDialog = savedInstanceState.getBoolean("is_showing_dialog");
            for(int i = 0; i<list.size(); i++){
                isSelected.add(mSelectedItems[i]);
            }
        }
    }
}
