package com.gopmgo.module.result_as_dev;


public class ResultAsDevInjector {

    public static ResultAsDevInjector resultAsDevInjector;

    public ResultAsDevInjector() {
        injectDependency();
    }

    public static ResultAsDevInjector getInstance() {
        if (resultAsDevInjector == null) {
            resultAsDevInjector = new ResultAsDevInjector();
        }
        return resultAsDevInjector;
    }

    void injectDependency() {
        ResultAsDevFragment.injectIResultAsDevPresenter(ResultAsDevPresenter.getInstance());
        ResultAsDevFragment.injectAdapter(new ResultAsDevAdapter());
        // TODO: Add your class dependency in this module here
    }
}