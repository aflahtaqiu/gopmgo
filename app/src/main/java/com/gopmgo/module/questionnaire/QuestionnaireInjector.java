package com.gopmgo.module.questionnaire;


public class QuestionnaireInjector {

    public static QuestionnaireInjector questionnaireInjector;

    public static QuestionnaireInjector getInstance () {
        if(questionnaireInjector == null) {
            questionnaireInjector = new QuestionnaireInjector();
        }
        return questionnaireInjector;
    }

    public QuestionnaireInjector () {
        injectDependency();
    }

    void injectDependency () {
        QuestionnaireFragment.injectIQuestionnairePresenter(QuestionnairePresenter.getInstance());
        QuestionnaireFragment.setAdapter(QuestionnaireAdapter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}