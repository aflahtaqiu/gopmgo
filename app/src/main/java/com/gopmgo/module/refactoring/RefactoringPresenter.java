package com.gopmgo.module.refactoring;

import android.content.Context;

import com.gopmgo.data.source.IAntiPatternSolutionDataSource;
import com.gopmgo.di.IDataInjector;
import com.gopmgo.model.AntiPatternSolution;

import java.util.ArrayList;
import java.util.List;


public class RefactoringPresenter implements IRefactoringPresenter {

    private static RefactoringPresenter instance;
    private static IDataInjector dataInjector;
    private IRefactoringView view;

    public static RefactoringPresenter getInstance() {
        if (instance == null) {
            instance = new RefactoringPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IRefactoringView _view) {
        view = _view;
    }

    @Override
    public void getSolutionList(Context context, int idAntiPattern) {
        dataInjector.provideSolutionRepository(context).getRefactorings(new IAntiPatternSolutionDataSource.SolutionCallback() {
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