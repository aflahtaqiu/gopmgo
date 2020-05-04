package com.gopmgo.module.self_repair;


public class SelfRepairInjector {

    private static SelfRepairInjector self_repairInjector;

    SelfRepairInjector() {
        injectDependency();
    }

    public static SelfRepairInjector getInstance() {
        if (self_repairInjector == null) {
            self_repairInjector = new SelfRepairInjector();
        }
        return self_repairInjector;
    }

    void injectDependency() {
        SelfRepairFragment.injectISelfRepairPresenter(SelfRepairPresenter.getInstance());
        SelfRepairFragment.injectAdapter(new SelfRepairAdapter());
        // TODO: Add your class dependency in this module here
    }
}