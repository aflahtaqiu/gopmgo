package com.gopmgo.module.done_questionnaire;


public class DoneQuestionnaireInjector {

    public static DoneQuestionnaireInjector doneQuestionnaireInjector;

    public DoneQuestionnaireInjector() {
        injectDependency();
    }

    public static DoneQuestionnaireInjector getInstance() {
        if (doneQuestionnaireInjector == null) {
            doneQuestionnaireInjector = new DoneQuestionnaireInjector();
        }
        return doneQuestionnaireInjector;
    }

    void injectDependency() {
        DoneQuestionnaireFragment.injectIDoneQuestionnairePresenter(DoneQuestionnairePresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}