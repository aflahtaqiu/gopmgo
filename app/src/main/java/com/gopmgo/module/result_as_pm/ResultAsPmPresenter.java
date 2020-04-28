package com.gopmgo.module.result_as_pm;

import com.gopmgo.di.IDataInjector;


public class ResultAsPmPresenter implements IResultAsPmPresenter {

    private static ResultAsPmPresenter instance;
    private static IDataInjector dataInjector;
    private IResultAsPmView view;

    public static ResultAsPmPresenter getInstance() {
        if (instance == null) {
            instance = new ResultAsPmPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IResultAsPmView _view) {
        view = _view;
    }
}