package com.gopmgo.module.self_repair;

import android.content.Context;

import com.gopmgo.data.source.IAntiPatternSolutionDataSource;
import com.gopmgo.di.IDataInjector;
import com.gopmgo.model.AntiPatternSolution;

import java.util.ArrayList;
import java.util.List;


public class SelfRepairPresenter implements ISelfRepairPresenter {

    private static SelfRepairPresenter instance;
    private static IDataInjector dataInjector;
    private ISelfRepairView view;

    public static SelfRepairPresenter getInstance() {
        if (instance == null) {
            instance = new SelfRepairPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(ISelfRepairView _view) {
        view = _view;
    }

    @Override
    public void getSolutionList(Context context, int idAntiPattern) {
        dataInjector.provideSolutionRepository(context).getSelfRepairs(new IAntiPatternSolutionDataSource.SolutionCallback() {
            @Override
            public void onSuccess(List<AntiPatternSolution> data) {
                List<AntiPatternSolution> solutionList = new ArrayList<>();
                for (AntiPatternSolution solution : data) {
                    if (solution.getIdAntiPattern() == idAntiPattern)
                        solutionList.add(solution);
                }
                view.showListSolution(solutionList);
            }

            @Override
            public void onError(String errorMessage) {
                view.showMessage(errorMessage);
            }
        });
    }
}