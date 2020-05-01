package com.gopmgo.module.done_questionnaire;

import com.gopmgo.di.IDataInjector;


public class DoneQuestionnairePresenter implements IDoneQuestionnairePresenter {

    private static DoneQuestionnairePresenter instance;
    private static IDataInjector dataInjector;
    private IDoneQuestionnaireView view;

    public static DoneQuestionnairePresenter getInstance() {
        if (instance == null) {
            instance = new DoneQuestionnairePresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IDoneQuestionnaireView _view) {
        view = _view;
    }
}