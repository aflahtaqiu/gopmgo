package com.gopmgo.data.remote.api;


import com.gopmgo.base.BaseResponse;
import com.gopmgo.model.Questionnaire;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiEndpoint {

    @GET("mgmtquest")
    Call<BaseResponse<List<Questionnaire>>> getDevQuestionnaires ();

    @GET("pmquest")
    Call<BaseResponse<List<Questionnaire>>> getPmQuestionnaires ();
}