package com.gopmgo.module.questionnaire;

import android.content.Context;

import com.gopmgo.base.IBasePresenter;

import java.util.HashMap;

public interface IQuestionnairePresenter extends IBasePresenter {
    void injectView(IQuestionnaireView _view);
    void getQuestionnaires (Context context, String roleQuest);
    void updateQuestionnaires();
    void saveAnswer(int idQuestion, int answer);
    HashMap<Integer, Integer> storeAnswer();
}