package com.gopmgo.module.questionnaire;

import android.content.Context;
import android.util.Log;

import com.gopmgo.data.source.IQuestionnaireDataSource;
import com.gopmgo.di.IDataInjector;
import com.gopmgo.model.Questionnaire;

import java.util.List;


public class QuestionnairePresenter implements IQuestionnairePresenter {

    private IQuestionnaireView view;
    private static QuestionnairePresenter instance;
    private static IDataInjector dataInjector;

    private String devRoleQuest = "dev";
    private String pmRoleQuest = "pm";

    public static QuestionnairePresenter getInstance () {
        if(instance == null) {
            instance = new QuestionnairePresenter();
        }
        return instance;
    }

    @Override
    public void injectView(IQuestionnaireView _view) {
        view =_view;
    }

    @Override
    public void getQuestionnaires(Context context) {
        dataInjector.provideQuestionnaireRepository(context).getDevQuestionnaires(
                new IQuestionnaireDataSource.QuestionnaireCallback() {
                    @Override
                    public void onSuccess(List<Questionnaire> data) {
                        for (Questionnaire questionnaire : data) {
                            Log.e("lele", questionnaire.toString());
                        }
                    }

                    @Override
                    public void onError(String errorMessage) {
                        Log.e("lele", errorMessage);
                    }
                });
    }

    public static void setDataInjector(IDataInjector _datInjector) {
            dataInjector = _datInjector;
    }
}