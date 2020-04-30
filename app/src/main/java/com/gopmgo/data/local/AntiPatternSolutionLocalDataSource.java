package com.gopmgo.data.local;

import android.content.Context;

import com.gopmgo.data.source.IAntiPatternSolutionDataSource;
import com.gopmgo.model.AntiPatternSolution;

public class AntiPatternSolutionLocalDataSource implements IAntiPatternSolutionDataSource {

    private Context context;

    public AntiPatternSolutionLocalDataSource(Context context) {
        this.context = context;
    }

    @Override
    public void getBandAids(SolutionCallback callback) {

    }

    @Override
    public void getSelfRepairs(SolutionCallback callback) {

    }

    @Override
    public void getRefactorings(SolutionCallback callback) {

    }
}