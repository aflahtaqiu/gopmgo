package com.gopmgo.module.refactoring;

import com.gopmgo.di.IDataInjector;


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
}