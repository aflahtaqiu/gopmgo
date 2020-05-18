package com.gopmgo.module.pre_questionnaire;


public class PreQuestionnaireInjector {

    public static PreQuestionnaireInjector pre_questionnaireInjector;

    public PreQuestionnaireInjector() {
        injectDependency();
    }

    public static PreQuestionnaireInjector getInstance() {
        if (pre_questionnaireInjector == null) {
            pre_questionnaireInjector = new PreQuestionnaireInjector();
        }
        return pre_questionnaireInjector;
    }

    void injectDependency() {
        PreQuestionnaireFragment.injectIPreQuestionnairePresenter(PreQuestionnairePresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}