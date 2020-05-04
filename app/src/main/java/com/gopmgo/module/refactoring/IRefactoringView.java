package com.gopmgo.module.refactoring;


import com.gopmgo.base.IBaseView;
import com.gopmgo.model.AntiPatternSolution;

import java.util.List;

public interface IRefactoringView extends IBaseView {
    void injectPresenter();
    void showListSolution(List<AntiPatternSolution> solutionList);
}