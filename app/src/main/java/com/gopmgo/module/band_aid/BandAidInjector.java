package com.gopmgo.module.band_aid;


public class BandAidInjector {

    public static BandAidInjector band_aidInjector;

    public BandAidInjector() {
        injectDependency();
    }

    public static BandAidInjector getInstance() {
        if (band_aidInjector == null) {
            band_aidInjector = new BandAidInjector();
        }
        return band_aidInjector;
    }

    void injectDependency() {
        BandAidFragment.injectIBandAidPresenter(BandAidPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}