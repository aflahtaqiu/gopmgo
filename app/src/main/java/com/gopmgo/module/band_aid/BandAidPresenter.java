package com.gopmgo.module.band_aid;

import android.content.Context;

import com.gopmgo.data.source.IAntiPatternSolutionDataSource;
import com.gopmgo.di.IDataInjector;
import com.gopmgo.model.AntiPatternSolution;

import java.util.ArrayList;
import java.util.List;


public class BandAidPresenter implements IBandAidPresenter {

    private static BandAidPresenter instance;
    private static IDataInjector dataInjector;
    private IBandAidView view;

    public static BandAidPresenter getInstance() {
        if (instance == null) {
            instance = new BandAidPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IBandAidView _view) {
        view = _view;
    }

    @Override
    public void getSolutionList(Context context, int idAntiPattern) {
        dataInjector.provideSolutionRepository(context).getBandAids(new IAntiPatternSolutionDataSource.SolutionCallback() {
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