package com.gopmgo.module.result_as_dev;


import com.gopmgo.base.IBaseView;
import com.gopmgo.model.AntiPattern;

import java.util.List;

public interface IResultAsDevView extends IBaseView {
    void injectPresenter();

    void showDataLayout();
    void hideDataLayout();

    void setListAntiPattern(List<AntiPattern> antiPatternList);
}