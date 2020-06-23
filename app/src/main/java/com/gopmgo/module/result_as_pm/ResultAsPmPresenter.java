package com.gopmgo.module.result_as_pm;

import android.content.Context;
import android.util.Log;

import com.aflah.libraryku.SharedPrefUtils;
import com.gopmgo.data.source.IAntiPatternDataSource;
import com.gopmgo.di.IDataInjector;
import com.gopmgo.model.AntiPattern;
import com.gopmgo.module.result_as_dev.ResultAsDevPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResultAsPmPresenter implements IResultAsPmPresenter {

    private static ResultAsPmPresenter instance;
    private static IDataInjector dataInjector;
    private IResultAsPmView view;
    private HashMap<Integer, Integer> answerMaps = new HashMap<>();

    public static ResultAsPmPresenter getInstance() {
        if (instance == null) {
            instance = new ResultAsPmPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IResultAsPmView _view) {
        view = _view;
    }

    @Override
    public void getAntiPatterns(Context context) {
        dataInjector.provideAntiPatternRepository(context).getPmAntiPattern(new IAntiPatternDataSource.AntiPatternCallback() {
            @Override
            public void onSuccess(List<AntiPattern> data) {
                List<AntiPattern> selectedAntiPattern = new ArrayList<>();

                for (Map.Entry<Integer, Integer> entry : answerMaps.entrySet()) {
                    for(AntiPattern antiPattern : data){
                        if (antiPattern.getId() == Integer.parseInt(String.valueOf(entry.getKey()))){
                            Log.d(ResultAsPmPresenter.class.getSimpleName(), "id antipattern: " + entry.getKey());
                            selectedAntiPattern.add(antiPattern);
                        }
                    }
                }
                view.setListAntiPattern(selectedAntiPattern);
            }

            @Override
            public void onError(String errorMessage) {
                view.showMessage(errorMessage);
            }
        });
    }

    @Override
    public void getAnsweredQuestion() {
        String sharedPrefKey = "answered_question_pm";
        answerMaps = (HashMap<Integer, Integer>) SharedPrefUtils.getObjectSharedPref(sharedPrefKey, null, HashMap.class);
    }

    @Override
    public boolean isAnsweredQuestionnaire() {
        return answerMaps != null && !answerMaps.isEmpty();
    }
}