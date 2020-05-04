package com.gopmgo.module.detail_antipattern;


public class DetailAntipatternInjector {

    public DetailAntipatternInjector() {
        injectDependency();
    }

    void injectDependency() {
        DetailAntipatternFragment.injectIDetailAntipatternPresenter(DetailAntipatternPresenter.getInstance());
    }
}