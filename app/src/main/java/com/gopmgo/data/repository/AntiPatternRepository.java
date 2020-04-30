package com.gopmgo.data.repository;

import android.content.Context;

import com.gopmgo.data.source.IAntiPatternDataSource;
import com.gopmgo.data.remote.AntiPatternRemoteDataSource;
import com.gopmgo.data.local.AntiPatternLocalDataSource;
import com.gopmgo.model.AntiPattern;

import java.util.List;


public class AntiPatternRepository implements IAntiPatternDataSource {

    private static AntiPatternRepository dataRepository;
    private AntiPatternRemoteDataSource remoteDataSource;
    private AntiPatternLocalDataSource localDataSource;

    AntiPatternRepository(AntiPatternRemoteDataSource remoteDataSource, AntiPatternLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static AntiPatternRepository getInstance(Context context) {
        if (dataRepository == null) {
            dataRepository = new AntiPatternRepository(new AntiPatternRemoteDataSource(), new AntiPatternLocalDataSource(context));
        }
        return dataRepository;
    }

    @Override
    public void getDevAntiPattern(final AntiPatternCallback callback) {
        remoteDataSource.getDevAntiPattern(new AntiPatternCallback() {
            @Override
            public void onSuccess(List<AntiPattern> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }

    @Override
    public void getPmAntiPattern(final AntiPatternCallback callback) {
        remoteDataSource.getPmAntiPattern(new AntiPatternCallback() {
            @Override
            public void onSuccess(List<AntiPattern> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }
}