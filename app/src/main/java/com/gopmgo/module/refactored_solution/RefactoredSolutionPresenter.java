package com.gopmgo.module.refactored_solution;

import com.gopmgo.di.IDataInjector;


public class RefactoredSolutionPresenter implements IRefactoredSolutionPresenter {

    private static RefactoredSolutionPresenter instance;
    private static IDataInjector dataInjector;
    private IRefactoredSolutionView view;

    public static RefactoredSolutionPresenter getInstance() {
        if (instance == null) {
            instance = new RefactoredSolutionPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IRefactoredSolutionView _view) {
        view = _view;
    }
}