package com.gopmgo.module.refactored_solution;


public class RefactoredSolutionInjector {

    public static RefactoredSolutionInjector refactored_solutionInjector;

    public RefactoredSolutionInjector() {
        injectDependency();
    }

    public static RefactoredSolutionInjector getInstance() {
        if (refactored_solutionInjector == null) {
            refactored_solutionInjector = new RefactoredSolutionInjector();
        }
        return refactored_solutionInjector;
    }

    void injectDependency() {
        RefactoredSolutionFragment.injectIRefactoredSolutionPresenter(RefactoredSolutionPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}