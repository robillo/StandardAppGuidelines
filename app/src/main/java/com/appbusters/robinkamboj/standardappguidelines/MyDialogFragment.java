package com.appbusters.robinkamboj.standardappguidelines;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDialogFragment extends DialogFragment{

    String temp = "->";

    public static MyDialogFragment newInstance(String temp){
        MyDialogFragment fragment = new MyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("list", temp);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args!=null) temp = temp.concat(args.getString("list"));
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Test Dialog")
                .setMessage("This Is A Test Dialog With Selected Items = " + temp)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Pressed OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                    }
                }).create();
    }
}
