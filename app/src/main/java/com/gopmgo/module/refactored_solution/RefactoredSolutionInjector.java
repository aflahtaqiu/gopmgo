package com.gopmgo.module.refactored_solution;


public class RefactoredSolutionInjector {

    public static RefactoredSolutionInjector refactoredSolutionInjector;

    public RefactoredSolutionInjector() {
        injectDependency();
    }

    public static RefactoredSolutionInjector getInstance() {
        if (refactoredSolutionInjector == null) {
            refactoredSolutionInjector = new RefactoredSolutionInjector();
        }
        return refactoredSolutionInjector;
    }

    void injectDependency() {
        RefactoredSolutionFragment.injectIRefactoredSolutionPresenter(RefactoredSolutionPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}