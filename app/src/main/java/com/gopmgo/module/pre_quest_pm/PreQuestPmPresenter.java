package com.gopmgo.module.pre_quest_pm;

import com.gopmgo.di.IDataInjector;


public class PreQuestPmPresenter implements IPreQuestPmPresenter {

    private static PreQuestPmPresenter instance;
    private static IDataInjector dataInjector;
    private IPreQuestPmView view;

    public static PreQuestPmPresenter getInstance() {
        if (instance == null) {
            instance = new PreQuestPmPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IPreQuestPmView _view) {
        view = _view;
    }
}