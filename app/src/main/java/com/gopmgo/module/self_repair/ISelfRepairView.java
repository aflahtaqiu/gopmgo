package com.gopmgo.module.self_repair;


import com.gopmgo.base.IBaseView;
import com.gopmgo.model.AntiPatternSolution;

import java.util.List;

public interface ISelfRepairView extends IBaseView {
    void injectPresenter();
    void showListSolution(List<AntiPatternSolution> solutionList);
}