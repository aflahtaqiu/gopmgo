package com.gopmgo.module.refactoring;


public class RefactoringInjector {

    public static RefactoringInjector refactoringInjector;

    public RefactoringInjector() {
        injectDependency();
    }

    public static RefactoringInjector getInstance() {
        if (refactoringInjector == null) {
            refactoringInjector = new RefactoringInjector();
        }
        return refactoringInjector;
    }

    void injectDependency() {
        RefactoringFragment.injectIRefactoringPresenter(RefactoringPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}