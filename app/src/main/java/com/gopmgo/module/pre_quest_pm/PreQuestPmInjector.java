package com.gopmgo.module.pre_quest_pm;


public class PreQuestPmInjector {

    public static PreQuestPmInjector pre_quest_pmInjector;

    public PreQuestPmInjector() {
        injectDependency();
    }

    public static PreQuestPmInjector getInstance() {
        if (pre_quest_pmInjector == null) {
            pre_quest_pmInjector = new PreQuestPmInjector();
        }
        return pre_quest_pmInjector;
    }

    void injectDependency() {
        PreQuestPmFragment.injectIPreQuestPmPresenter(PreQuestPmPresenter.getInstance());

        // TODO: Add your class dependency in this module here
    }
}