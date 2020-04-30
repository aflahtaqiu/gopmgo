package com.gopmgo.data.repository;

import android.content.Context;

import com.gopmgo.data.source.IQuestionnaireDataSource;
import com.gopmgo.data.remote.QuestionnaireRemoteDataSource;
import com.gopmgo.data.local.QuestionnaireLocalDataSource;
import com.gopmgo.model.Questionnaire;

import java.util.List;


public class QuestionnaireRepository implements IQuestionnaireDataSource {

    private static QuestionnaireRepository dataRepository;
    private QuestionnaireRemoteDataSource remoteDataSource;
    private QuestionnaireLocalDataSource localDataSource;

    QuestionnaireRepository(QuestionnaireRemoteDataSource remoteDataSource, QuestionnaireLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static QuestionnaireRepository getInstance(Context context) {
        if (dataRepository == null) {
            dataRepository = new QuestionnaireRepository(new QuestionnaireRemoteDataSource(), new QuestionnaireLocalDataSource(context));
        }
        return dataRepository;
    }

    @Override
    public void getDevQuestionnaires(final QuestionnaireCallback callback) {
        remoteDataSource.getDevQuestionnaires(new QuestionnaireCallback() {
            @Override
            public void onSuccess(List<Questionnaire> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }

    @Override
    public void getPmQuestionnaires(final QuestionnaireCallback callback) {
        remoteDataSource.getPmQuestionnaires(new QuestionnaireCallback() {
            @Override
            public void onSuccess(List<Questionnaire> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }
}