package com.gopmgo.data.repository;

import android.content.Context;

import com.gopmgo.data.source.IAntiPatternSolutionDataSource;
import com.gopmgo.data.remote.AntiPatternSolutionRemoteDataSource;
import com.gopmgo.data.local.AntiPatternSolutionLocalDataSource;
import com.gopmgo.model.AntiPatternSolution;

import java.util.List;


public class AntiPatternSolutionRepository implements IAntiPatternSolutionDataSource {

    private static AntiPatternSolutionRepository dataRepository;
    private AntiPatternSolutionRemoteDataSource remoteDataSource;
    private AntiPatternSolutionLocalDataSource localDataSource;

    AntiPatternSolutionRepository(AntiPatternSolutionRemoteDataSource remoteDataSource, AntiPatternSolutionLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static AntiPatternSolutionRepository getInstance(Context context) {
        if (dataRepository == null) {
            dataRepository = new AntiPatternSolutionRepository(new AntiPatternSolutionRemoteDataSource(), new AntiPatternSolutionLocalDataSource(context));
        }
        return dataRepository;
    }

    @Override
    public void getBandAids(final SolutionCallback callback) {
        remoteDataSource.getBandAids(new SolutionCallback() {
            @Override
            public void onSuccess(List<AntiPatternSolution> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }

    @Override
    public void getSelfRepairs(final SolutionCallback callback) {
        remoteDataSource.getSelfRepairs(new SolutionCallback() {
            @Override
            public void onSuccess(List<AntiPatternSolution> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }

    @Override
    public void getRefactorings(SolutionCallback callback) {
        remoteDataSource.getRefactorings(new SolutionCallback() {
            @Override
            public void onSuccess(List<AntiPatternSolution> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }
}