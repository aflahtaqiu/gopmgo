package com.gopmgo.module.self_repair;


import android.content.Context;

import com.gopmgo.base.IBasePresenter;

public interface ISelfRepairPresenter extends IBasePresenter {
    void injectView(ISelfRepairView _view);
    void getSolutionList (Context context, int idAntiPattern);
}