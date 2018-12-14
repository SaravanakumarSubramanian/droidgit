package com.inferno.droidgit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity implements NavContracts {

    private Context context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        context = this;
    }

    @Override
    public void startActivity(Class<? extends AppCompatActivity> claz, Bundle args) {
        Intent activityIntent = new Intent(context,claz);
        startActivity(activityIntent,args);
    }

    @Override
    public void startFragment(FragmentManager fragmentManager, Fragment fragment, boolean addToBackstack, Bundle args) {
        if(fragment!=null){
            try{
                if(fragment.isAdded()){
                    return; //or return false/true, based on where you are calling from
                }
                String backStateName = fragment.getClass().getName();
                try{
                    if (args != null && !fragment.isAdded()) fragment.setArguments(args);
                }catch (Exception e){
                    e.printStackTrace();
                }


                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content_view, fragment, backStateName);
                if (addToBackstack) transaction.addToBackStack(backStateName);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
