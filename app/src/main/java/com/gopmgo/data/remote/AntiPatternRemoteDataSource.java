package com.gopmgo.data.remote;

import com.gopmgo.base.BaseResponse;
import com.gopmgo.data.source.IAntiPatternDataSource;
import com.gopmgo.base.BaseRemoteDataSource;
import com.gopmgo.model.AntiPattern;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AntiPatternRemoteDataSource extends BaseRemoteDataSource implements IAntiPatternDataSource {

    @Override
    public void getDevAntiPattern(final AntiPatternCallback callback) {
        Call<BaseResponse<List<AntiPattern>>> call = apiEndpoint.getDevAntiPatterns();
        call.enqueue(new Callback<BaseResponse<List<AntiPattern>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<AntiPattern>>> call, Response<BaseResponse<List<AntiPattern>>> response) {
                callback.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<AntiPattern>>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getPmAntiPattern(final AntiPatternCallback callback) {
        Call<BaseResponse<List<AntiPattern>>> call = apiEndpoint.getPmAntiPatterns();
        call.enqueue(new Callback<BaseResponse<List<AntiPattern>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<AntiPattern>>> call, Response<BaseResponse<List<AntiPattern>>> response) {
                callback.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<AntiPattern>>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}