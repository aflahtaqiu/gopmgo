package com.gopmgo.module.result_as_pm;


public class ResultAsPmInjector {

    public static ResultAsPmInjector result_as_pmInjector;

    public ResultAsPmInjector() {
        injectDependency();
    }

    public static ResultAsPmInjector getInstance() {
        if (result_as_pmInjector == null) {
            result_as_pmInjector = new ResultAsPmInjector();
        }
        return result_as_pmInjector;
    }

    void injectDependency() {
        ResultAsPmFragment.injectIResultAsPmPresenter(ResultAsPmPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}