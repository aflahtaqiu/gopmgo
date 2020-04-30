package com.gopmgo.data.remote.api;

import com.gopmgo.base.BaseResponse;
import com.gopmgo.model.AntiPattern;
import com.gopmgo.model.AntiPatternSolution;
import com.gopmgo.model.Questionnaire;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiEndpoint {

    @GET("devquest")
    Call<BaseResponse<List<Questionnaire>>> getDevQuestionnaires ();

    @GET("pmquest")
    Call<BaseResponse<List<Questionnaire>>> getPmQuestionnaires ();

    @GET("pmresult")
    Call<BaseResponse<List<AntiPattern>>> getPmAntiPatterns() ;

    @GET("devresult")
    Call<BaseResponse<List<AntiPattern>>> getDevAntiPatterns();

    @GET("bandaid")
    Call<BaseResponse<List<AntiPatternSolution>>> getBandAids();

    @GET("selfrepair")
    Call<BaseResponse<List<AntiPatternSolution>>> getSelfRepairs();

    @GET("refactoring")
    Call<BaseResponse<List<AntiPatternSolution>>> getRefactorings();
}