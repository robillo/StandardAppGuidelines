package com.appbusters.robinkamboj.standardappguidelines;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(null == savedInstanceState){
            initFragment(MainFragment.newInstance());
        }
    }

    private void initFragment(Fragment fragment){
        Log.e("INIT FRAGMENT", "CALLED");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    public void showMyDialog(ArrayList<String> list){
        MyDialogFragment fragment = MyDialogFragment.newInstance(list);
        fragment.show(getSupportFragmentManager(), "TAG");
    }
}
