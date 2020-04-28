package com.gopmgo.module.band_aid;

import com.gopmgo.di.IDataInjector;


public class BandAidPresenter implements IBandAidPresenter {

    private static BandAidPresenter instance;
    private static IDataInjector dataInjector;
    private IBandAidView view;

    public static BandAidPresenter getInstance() {
        if (instance == null) {
            instance = new BandAidPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IBandAidView _view) {
        view = _view;
    }
}