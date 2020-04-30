package com.gopmgo.module.splash_screen;

import com.gopmgo.di.IDataInjector;

public class SplashScreenPresenter implements ISplashScreenPresenter {

    private static ISplashScreenView view;
    private static SplashScreenPresenter instance;
    private static IDataInjector dataInjector;

    public static SplashScreenPresenter getInstance() {
        if (instance == null) {
            instance = new SplashScreenPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(ISplashScreenView _view) {
        view = _view;
    }
}