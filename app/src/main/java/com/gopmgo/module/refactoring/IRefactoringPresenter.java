package com.gopmgo.module.refactoring;


import android.content.Context;

import com.gopmgo.base.IBasePresenter;

public interface IRefactoringPresenter extends IBasePresenter {
    void injectView(IRefactoringView _view);
    void getSolutionList (Context context, int idAntiPattern);
}