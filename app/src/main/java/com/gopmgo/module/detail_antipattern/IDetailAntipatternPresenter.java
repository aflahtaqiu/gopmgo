package com.gopmgo.module.detail_antipattern;


import android.content.Context;

import com.gopmgo.base.IBasePresenter;

public interface IDetailAntipatternPresenter extends IBasePresenter {
    void injectView(IDetailAntipatternView _view);

    void getDetailAntiPattern(Context context, int idAntiPattern);
}