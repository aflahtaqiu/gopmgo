package com.gopmgo.module.detail_antipattern;


public class DetailAntipatternInjector {

    public static DetailAntipatternInjector detail_antipatternInjector;

    public DetailAntipatternInjector() {
        injectDependency();
    }

    public static DetailAntipatternInjector getInstance() {
        if (detail_antipatternInjector == null) {
            detail_antipatternInjector = new DetailAntipatternInjector();
        }
        return detail_antipatternInjector;
    }

    void injectDependency() {
        DetailAntipatternFragment.injectIDetailAntipatternPresenter(DetailAntipatternPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}