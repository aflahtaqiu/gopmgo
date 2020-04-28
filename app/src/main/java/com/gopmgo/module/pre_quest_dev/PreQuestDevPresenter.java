package com.gopmgo.module.pre_quest_dev;

import com.gopmgo.di.IDataInjector;


public class PreQuestDevPresenter implements IPreQuestDevPresenter {

    private static PreQuestDevPresenter instance;
    private static IDataInjector dataInjector;
    private IPreQuestDevView view;

    public static PreQuestDevPresenter getInstance() {
        if (instance == null) {
            instance = new PreQuestDevPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IPreQuestDevView _view) {
        view = _view;
    }
}