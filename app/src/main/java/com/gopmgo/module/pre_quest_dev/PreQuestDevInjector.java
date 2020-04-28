package com.gopmgo.module.pre_quest_dev;


public class PreQuestDevInjector {

    public static PreQuestDevInjector pre_quest_devInjector;

    public PreQuestDevInjector() {
        injectDependency();
    }

    public static PreQuestDevInjector getInstance() {
        if (pre_quest_devInjector == null) {
            pre_quest_devInjector = new PreQuestDevInjector();
        }
        return pre_quest_devInjector;
    }

    void injectDependency() {
        PreQuestDevFragment.injectIPreQuestDevPresenter(PreQuestDevPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}