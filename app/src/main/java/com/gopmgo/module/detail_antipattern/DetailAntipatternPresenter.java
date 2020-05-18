package com.gopmgo.module.detail_antipattern;

import com.gopmgo.di.IDataInjector;


public class DetailAntipatternPresenter implements IDetailAntipatternPresenter {

    private static DetailAntipatternPresenter instance;
    private static IDataInjector dataInjector;
    private IDetailAntipatternView view;

    public static DetailAntipatternPresenter getInstance() {
        if (instance == null) {
            instance = new DetailAntipatternPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IDetailAntipatternView _view) {
        view = _view;
    }
}