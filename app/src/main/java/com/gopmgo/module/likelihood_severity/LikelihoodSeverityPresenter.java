package com.gopmgo.module.likelihood_severity;

import com.gopmgo.di.IDataInjector;


public class LikelihoodSeverityPresenter implements ILikelihoodSeverityPresenter {

    private static LikelihoodSeverityPresenter instance;
    private static IDataInjector dataInjector;
    private ILikelihoodSeverityView view;

    public static LikelihoodSeverityPresenter getInstance() {
        if (instance == null) {
            instance = new LikelihoodSeverityPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(ILikelihoodSeverityView _view) {
        view = _view;
    }
}