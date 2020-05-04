package com.gopmgo.module.result_as_dev;


import android.content.Context;

import com.gopmgo.base.IBasePresenter;

public interface IResultAsDevPresenter extends IBasePresenter {
    void injectView(IResultAsDevView _view);

    void getAntiPatterns (Context context);
    void getAnsweredQuestion ();
    boolean isAnsweredQuestionnaire ();
}