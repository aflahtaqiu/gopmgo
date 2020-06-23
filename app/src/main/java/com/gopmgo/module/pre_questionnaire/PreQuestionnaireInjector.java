package com.gopmgo.module.pre_questionnaire;


public class PreQuestionnaireInjector {

    public static PreQuestionnaireInjector preQuestionnaireInjector;

    public PreQuestionnaireInjector() {
        injectDependency();
    }

    public static PreQuestionnaireInjector getInstance() {
        if (preQuestionnaireInjector == null) {
            preQuestionnaireInjector = new PreQuestionnaireInjector();
        }
        return preQuestionnaireInjector;
    }

    void injectDependency() {
        PreQuestionnaireFragment.injectIPreQuestionnairePresenter(PreQuestionnairePresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}