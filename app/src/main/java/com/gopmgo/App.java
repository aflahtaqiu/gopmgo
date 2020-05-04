package com.gopmgo;

import android.app.Application;

import com.aflah.libraryku.SharedPrefUtils;
import com.gopmgo.di.DataInjector;
import com.gopmgo.module.band_aid.BandAidInjector;
import com.gopmgo.module.band_aid.BandAidPresenter;
import com.gopmgo.module.questionnaire.QuestionnaireInjector;
import com.gopmgo.module.questionnaire.QuestionnairePresenter;
import com.gopmgo.module.refactoring.RefactoringInjector;
import com.gopmgo.module.refactoring.RefactoringPresenter;
import com.gopmgo.module.result_as_dev.ResultAsDevInjector;
import com.gopmgo.module.result_as_dev.ResultAsDevPresenter;
import com.gopmgo.module.result_as_pm.ResultAsPmInjector;
import com.gopmgo.module.result_as_pm.ResultAsPmPresenter;
import com.gopmgo.module.self_repair.SelfRepairInjector;
import com.gopmgo.module.self_repair.SelfRepairPresenter;
import com.gopmgo.module.splash_screen.SplashScreenActivity;


public class App extends Application {

    private String prefName = "gopmgo";

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefUtils.initSharedPref(prefName, getApplicationContext());
        addModuleDependency();
    }

    void addModuleDependency() {
        SplashScreenActivity.injectDestinationClass(MainActivity.class);

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
    }
}