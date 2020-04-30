package com.gopmgo;

import android.app.Application;

import com.gopmgo.di.DataInjector;
import com.gopmgo.module.questionnaire.QuestionnaireInjector;
import com.gopmgo.module.questionnaire.QuestionnairePresenter;
import com.gopmgo.module.splash_screen.SplashScreenActivity;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        addModuleDependency();
    }

    void addModuleDependency() {
        SplashScreenActivity.injectDestinationClass(MainActivity.class);


        QuestionnaireInjector.getInstance();
        QuestionnairePresenter.setDataInjector(DataInjector.getInstance());
    }
}