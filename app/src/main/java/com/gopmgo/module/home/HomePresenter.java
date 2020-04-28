package com.gopmgo.module.home;

import com.gopmgo.di.IDataInjector;


public class HomePresenter implements IHomePresenter {

    private static HomePresenter instance;
    private static IDataInjector dataInjector;
    private IHomeView view;

    public static HomePresenter getInstance() {
        if (instance == null) {
            instance = new HomePresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IHomeView _view) {
        view = _view;
    }
}