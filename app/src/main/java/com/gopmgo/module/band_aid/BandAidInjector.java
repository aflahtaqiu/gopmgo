package com.gopmgo.module.band_aid;


public class BandAidInjector {

    public static BandAidInjector bandAidInjector;

    public BandAidInjector() {
        injectDependency();
    }

    public static BandAidInjector getInstance() {
        if (bandAidInjector == null) {
            bandAidInjector = new BandAidInjector();
        }
        return bandAidInjector;
    }

    void injectDependency() {
        BandAidFragment.injectIBandAidPresenter(BandAidPresenter.getInstance());
        BandAidFragment.injectAdapter(new BandAidAdapter());
        // TODO: Add your class dependency in this module here
    }
}