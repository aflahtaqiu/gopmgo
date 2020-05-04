package com.gopmgo.module.band_aid;


import com.gopmgo.base.IBaseView;
import com.gopmgo.model.AntiPatternSolution;

import java.util.List;

public interface IBandAidView extends IBaseView {
    void injectPresenter();
    void showListSolution(List<AntiPatternSolution> solutionList);
}