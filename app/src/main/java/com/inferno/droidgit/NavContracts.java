package com.inferno.droidgit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public interface NavContracts {

    void startActivity(Class<? extends AppCompatActivity> claz, Bundle args);
    void startFragment(FragmentManager fragmentManager, Fragment fragment, boolean addToBackstack, Bundle args);
}
