package com.gopmgo.module.result_as_dev;

import com.gopmgo.di.IDataInjector;


public class ResultAsDevPresenter implements IResultAsDevPresenter {

    private static ResultAsDevPresenter instance;
    private static IDataInjector dataInjector;
    private IResultAsDevView view;

    public static ResultAsDevPresenter getInstance() {
        if (instance == null) {
            instance = new ResultAsDevPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IResultAsDevView _view) {
        view = _view;
    }
}