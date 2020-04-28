package com.gopmgo.module.refactoring;


import com.gopmgo.base.IBasePresenter;

public interface IRefactoringPresenter extends IBasePresenter {
    void injectView(IRefactoringView _view);
}