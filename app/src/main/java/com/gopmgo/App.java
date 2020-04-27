package com.gopmgo;

import android.app.Application;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        addModuleDependency();
    }

    void addModuleDependency() {
        // TODO: Add your instance of module dependencies here
    }
}