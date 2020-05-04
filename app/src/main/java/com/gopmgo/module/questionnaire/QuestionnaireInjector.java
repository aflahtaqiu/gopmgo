package com.gopmgo.module.questionnaire;


public class QuestionnaireInjector {

    private static QuestionnaireInjector questionnaireInjector;

    public static QuestionnaireInjector getInstance () {
        if(questionnaireInjector == null) {
            questionnaireInjector = new QuestionnaireInjector();
        }
        return questionnaireInjector;
    }

    private QuestionnaireInjector() {
        injectDependency();
    }

    void injectDependency () {
        QuestionnaireFragment.injectIQuestionnairePresenter(QuestionnairePresenter.getInstance());
        QuestionnaireFragment.setAdapter(new QuestionnaireAdapter());

        // TODO: Add your class dependency in this module here
    }
}