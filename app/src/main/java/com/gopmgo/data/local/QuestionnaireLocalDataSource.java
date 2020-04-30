package com.gopmgo.data.local;

import android.content.Context;

import com.gopmgo.data.source.IQuestionnaireDataSource;
import com.gopmgo.model.Questionnaire;

public class QuestionnaireLocalDataSource implements IQuestionnaireDataSource {

    private Context context;

    public QuestionnaireLocalDataSource(Context context) {
        this.context = context;
    }

    @Override
    public void getDevQuestionnaires(QuestionnaireCallback callback) {

    }

    @Override
    public void getPmQuestionnaires(QuestionnaireCallback callback) {

    }
}