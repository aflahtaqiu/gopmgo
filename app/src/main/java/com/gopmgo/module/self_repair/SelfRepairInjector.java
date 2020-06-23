package com.gopmgo.module.self_repair;


public class SelfRepairInjector {

    private static SelfRepairInjector selfRepairInjector;

    SelfRepairInjector() {
        injectDependency();
    }

    public static SelfRepairInjector getInstance() {
        if (selfRepairInjector == null) {
            selfRepairInjector = new SelfRepairInjector();
        }
        return selfRepairInjector;
    }

    void injectDependency() {
        SelfRepairFragment.injectISelfRepairPresenter(SelfRepairPresenter.getInstance());
        SelfRepairFragment.injectAdapter(new SelfRepairAdapter());
        // TODO: Add your class dependency in this module here
    }
}