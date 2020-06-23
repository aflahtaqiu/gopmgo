package com.gopmgo.module.likelihood_severity;


public class LikelihoodSeverityInjector {

    public static LikelihoodSeverityInjector likelihoodSeverityInjector;

    public LikelihoodSeverityInjector() {
        injectDependency();
    }

    public static LikelihoodSeverityInjector getInstance() {
        if (likelihoodSeverityInjector == null) {
            likelihoodSeverityInjector = new LikelihoodSeverityInjector();
        }
        return likelihoodSeverityInjector;
    }

    void injectDependency() {
        LikelihoodSeverityFragment.injectILikelihoodSeverityPresenter(LikelihoodSeverityPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}