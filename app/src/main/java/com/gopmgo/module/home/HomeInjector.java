package com.gopmgo.module.home;


public class HomeInjector {

    public static HomeInjector homeInjector;

    public HomeInjector() {
        injectDependency();
    }

    public static HomeInjector getInstance() {
        if (homeInjector == null) {
            homeInjector = new HomeInjector();
        }
        return homeInjector;
    }

    void injectDependency() {
        HomeFragment.injectIHomePresenter(HomePresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}