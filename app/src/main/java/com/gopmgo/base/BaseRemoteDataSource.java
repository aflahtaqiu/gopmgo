package com.gopmgo.base;

import com.gopmgo.data.remote.api.IApiEndpoint;
import com.gopmgo.data.remote.api.ApiRetrofit;

public class BaseRemoteDataSource {
    protected IApiEndpoint apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
}