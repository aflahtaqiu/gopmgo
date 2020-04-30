package com.gopmgo.data.remote;

import com.gopmgo.base.BaseRemoteDataSource;
import com.gopmgo.base.BaseResponse;
import com.gopmgo.data.source.IQuestionnaireDataSource;
import com.gopmgo.model.Questionnaire;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionnaireRemoteDataSource extends BaseRemoteDataSource implements IQuestionnaireDataSource {

    @Override
    public void getDevQuestionnaires(final QuestionnaireCallback callback) {
        Call<BaseResponse<List<Questionnaire>>> call = apiEndpoint.getDevQuestionnaires();
        call.enqueue(new Callback<BaseResponse<List<Questionnaire>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Questionnaire>>> call, Response<BaseResponse<List<Questionnaire>>> response) {
                callback.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Questionnaire>>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getPmQuestionnaires(final QuestionnaireCallback callback) {
        Call<BaseResponse<List<Questionnaire>>> call = apiEndpoint.getPmQuestionnaires();
        call.enqueue(new Callback<BaseResponse<List<Questionnaire>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Questionnaire>>> call, Response<BaseResponse<List<Questionnaire>>> response) {
                callback.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Questionnaire>>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}