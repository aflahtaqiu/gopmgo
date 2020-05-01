package com.gopmgo.module.done_questionnaire;


public class DoneQuestionnaireInjector {

    public static DoneQuestionnaireInjector done_questionnaireInjector;

    public DoneQuestionnaireInjector() {
        injectDependency();
    }

    public static DoneQuestionnaireInjector getInstance() {
        if (done_questionnaireInjector == null) {
            done_questionnaireInjector = new DoneQuestionnaireInjector();
        }
        return done_questionnaireInjector;
    }

    void injectDependency() {
        DoneQuestionnaireFragment.injectIDoneQuestionnairePresenter(DoneQuestionnairePresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}