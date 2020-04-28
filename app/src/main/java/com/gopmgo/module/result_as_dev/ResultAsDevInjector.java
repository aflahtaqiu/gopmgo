package com.gopmgo.module.result_as_dev;


public class ResultAsDevInjector {

    public static ResultAsDevInjector result_as_devInjector;

    public ResultAsDevInjector() {
        injectDependency();
    }

    public static ResultAsDevInjector getInstance() {
        if (result_as_devInjector == null) {
            result_as_devInjector = new ResultAsDevInjector();
        }
        return result_as_devInjector;
    }

    void injectDependency() {
        ResultAsDevFragment.injectIResultAsDevPresenter(ResultAsDevPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}