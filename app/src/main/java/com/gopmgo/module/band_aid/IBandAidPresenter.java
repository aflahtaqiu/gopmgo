package com.gopmgo.module.band_aid;


import android.content.Context;

import com.gopmgo.base.IBasePresenter;

public interface IBandAidPresenter extends IBasePresenter {
    void injectView(IBandAidView _view);
    void getSolutionList (Context context, int idAntiPattern);
}