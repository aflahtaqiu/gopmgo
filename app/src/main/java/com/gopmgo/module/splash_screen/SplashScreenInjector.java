package com.gopmgo.module.splash_screen;


public class SplashScreenInjector {

    public SplashScreenInjector() {
        injectDependency();
    }

    void injectDependency() {
        SplashScreenActivity.injectISplashScreenPresenter(SplashScreenPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}