package com.gopmgo.module.likelihood_severity;


public class LikelihoodSeverityInjector {

    public static LikelihoodSeverityInjector likelihood_severityInjector;

    public LikelihoodSeverityInjector() {
        injectDependency();
    }

    public static LikelihoodSeverityInjector getInstance() {
        if (likelihood_severityInjector == null) {
            likelihood_severityInjector = new LikelihoodSeverityInjector();
        }
        return likelihood_severityInjector;
    }

    void injectDependency() {
        LikelihoodSeverityFragment.injectILikelihoodSeverityPresenter(LikelihoodSeverityPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}