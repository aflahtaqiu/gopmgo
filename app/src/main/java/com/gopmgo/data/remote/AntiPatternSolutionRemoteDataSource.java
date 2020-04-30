package com.gopmgo.data.remote;

import com.gopmgo.base.BaseResponse;
import com.gopmgo.data.source.IAntiPatternSolutionDataSource;
import com.gopmgo.base.BaseRemoteDataSource;
import com.gopmgo.model.AntiPatternSolution;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AntiPatternSolutionRemoteDataSource extends BaseRemoteDataSource implements IAntiPatternSolutionDataSource {

    @Override
    public void getBandAids(final SolutionCallback callback) {
        Call<BaseResponse<List<AntiPatternSolution>>> call = apiEndpoint.getBandAids();
        call.enqueue(new Callback<BaseResponse<List<AntiPatternSolution>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<AntiPatternSolution>>> call, Response<BaseResponse<List<AntiPatternSolution>>> response) {
                callback.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<AntiPatternSolution>>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getSelfRepairs(final SolutionCallback callback) {
        Call<BaseResponse<List<AntiPatternSolution>>> call = apiEndpoint.getSelfRepairs();
        call.enqueue(new Callback<BaseResponse<List<AntiPatternSolution>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<AntiPatternSolution>>> call, Response<BaseResponse<List<AntiPatternSolution>>> response) {
                callback.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<AntiPatternSolution>>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getRefactorings(final SolutionCallback callback) {
        Call<BaseResponse<List<AntiPatternSolution>>> call = apiEndpoint.getRefactorings();
        call.enqueue(new Callback<BaseResponse<List<AntiPatternSolution>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<AntiPatternSolution>>> call, Response<BaseResponse<List<AntiPatternSolution>>> response) {
                callback.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<AntiPatternSolution>>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}