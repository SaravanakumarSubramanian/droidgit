package com.inferno.droidgit;

import android.app.Application;

public class AppController extends Application {

    private static AppController instance;
    public static AppController getInstance(){
        if (instance== null) {
            synchronized(AppController.class) {
                if (instance == null)instance = new AppController();
            }
        }
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

}
