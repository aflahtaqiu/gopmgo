package com.gopmgo;

import android.app.Application;

import com.aflah.libraryku.SharedPrefUtils;
import com.gopmgo.base.TypefaceUtil;
import com.gopmgo.di.DataInjector;
import com.gopmgo.module.band_aid.BandAidFragment;
import com.gopmgo.module.band_aid.BandAidInjector;
import com.gopmgo.module.band_aid.BandAidPresenter;
import com.gopmgo.module.detail_antipattern.DetailAntipatternFragmentAdapter;
import com.gopmgo.module.detail_antipattern.DetailAntipatternInjector;
import com.gopmgo.module.done_questionnaire.DoneQuestionnaireFragment;
import com.gopmgo.module.pre_questionnaire.PreQuestionnaireInjector;
import com.gopmgo.module.pre_questionnaire.PreQuestionnairePresenter;
import com.gopmgo.module.questionnaire.QuestionnaireInjector;
import com.gopmgo.module.questionnaire.QuestionnairePresenter;
import com.gopmgo.module.refactoring.RefactoringFragment;
import com.gopmgo.module.refactoring.RefactoringInjector;
import com.gopmgo.module.refactoring.RefactoringPresenter;
import com.gopmgo.module.result_as_dev.ResultAsDevInjector;
import com.gopmgo.module.result_as_dev.ResultAsDevPresenter;
import com.gopmgo.module.result_as_pm.ResultAsPmInjector;
import com.gopmgo.module.result_as_pm.ResultAsPmPresenter;
import com.gopmgo.module.self_repair.SelfRepairFragment;
import com.gopmgo.module.self_repair.SelfRepairInjector;
import com.gopmgo.module.self_repair.SelfRepairPresenter;
import com.gopmgo.module.splash_screen.SplashScreenActivity;


public class App extends Application {

    private String prefName = "gopmgo";

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefUtils.initSharedPref(prefName, getApplicationContext());
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/segoeui.ttf");
        addModuleDependency();
    }

    void addModuleDependency() {
        SplashScreenActivity.injectDestinationClass(MainActivity.class);
        DoneQuestionnaireFragment.injectMainClass(MainActivity.class);

        PreQuestionnaireInjector.getInstance();

        QuestionnaireInjector.getInstance();
        QuestionnairePresenter.setDataInjector(DataInjector.getInstance());

        ResultAsPmInjector.getInstance();
        ResultAsPmPresenter.setDataInjector(DataInjector.getInstance());

        ResultAsDevInjector.getInstance();
        ResultAsDevPresenter.setDataInjector(DataInjector.getInstance());

        BandAidInjector.getInstance();
        BandAidPresenter.setDataInjector(DataInjector.getInstance());

        SelfRepairInjector.getInstance();
        SelfRepairPresenter.setDataInjector(DataInjector.getInstance());

        RefactoringInjector.getInstance();
        RefactoringPresenter.setDataInjector(DataInjector.getInstance());

        new DetailAntipatternInjector();
        BandAidFragment bandAidFragment = new BandAidFragment();
        SelfRepairFragment selfRepairFragment = new SelfRepairFragment();
        RefactoringFragment refactoringFragment = new RefactoringFragment();

        DetailAntipatternFragmentAdapter.injectBandAidConnector(bandAidFragment);
        DetailAntipatternFragmentAdapter.injectSelfRepairConnector(selfRepairFragment);
        DetailAntipatternFragmentAdapter.injectRefactoringConnector(refactoringFragment);

        DetailAntipatternFragmentAdapter.addFragment(bandAidFragment, "Band Aid");
        DetailAntipatternFragmentAdapter.addFragment(selfRepairFragment, "Self Repair");
        DetailAntipatternFragmentAdapter.addFragment(refactoringFragment, "Refactoring");
    }
}