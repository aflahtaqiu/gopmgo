package com.gopmgo.module.result_as_pm;


import android.content.Context;

import com.gopmgo.base.IBasePresenter;

public interface IResultAsPmPresenter extends IBasePresenter {
    void injectView(IResultAsPmView _view);
    void getAntiPatterns (Context context);
    void getAnsweredQuestion ();
    boolean isAnsweredQuestionnaire ();
}