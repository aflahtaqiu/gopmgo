package com.gopmgo.module.self_repair;

import com.gopmgo.di.IDataInjector;


public class SelfRepairPresenter implements ISelfRepairPresenter {

    private static SelfRepairPresenter instance;
    private static IDataInjector dataInjector;
    private ISelfRepairView view;

    public static SelfRepairPresenter getInstance() {
        if (instance == null) {
            instance = new SelfRepairPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(ISelfRepairView _view) {
        view = _view;
    }
}