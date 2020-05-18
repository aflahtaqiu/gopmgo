package com.gopmgo.module.pre_questionnaire;

import com.gopmgo.di.IDataInjector;


public class PreQuestionnairePresenter implements IPreQuestionnairePresenter {

    private static PreQuestionnairePresenter instance;
    private IPreQuestionnaireView view;

    public static PreQuestionnairePresenter getInstance() {
        if (instance == null) {
            instance = new PreQuestionnairePresenter();
        }
        return instance;
    }

    @Override
    public void injectView(IPreQuestionnaireView _view) {
        view = _view;
    }

}