package com.gopmgo.module.result_as_pm;


import com.gopmgo.base.IBaseView;
import com.gopmgo.model.AntiPattern;

import java.util.List;

public interface IResultAsPmView extends IBaseView {
    void injectPresenter();
    void showDataLayout();
    void hideDataLayout();
    void setListAntiPattern(List<AntiPattern> antiPatternList);
}