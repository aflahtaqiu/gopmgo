package com.gopmgo.module.result_as_dev;

import android.content.Context;

import com.aflah.libraryku.SharedPrefUtils;
import com.gopmgo.data.source.IAntiPatternDataSource;
import com.gopmgo.di.IDataInjector;
import com.gopmgo.model.AntiPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResultAsDevPresenter implements IResultAsDevPresenter {

    private static ResultAsDevPresenter instance;
    private static IDataInjector dataInjector;
    private IResultAsDevView view;
    private HashMap<Integer, Integer> answerMaps = new HashMap<>();
    private String sharedPrefKey = "answered_question_dev";

    public static ResultAsDevPresenter getInstance() {
        if (instance == null) {
            instance = new ResultAsDevPresenter();
        }
        return instance;
    }

    public static void setDataInjector(IDataInjector _datInjector) {
        dataInjector = _datInjector;
    }

    @Override
    public void injectView(IResultAsDevView _view) {
        view = _view;
    }

    @Override
    public void getAntiPatterns(Context context) {
        dataInjector.provideAntiPatternRepository(context).getDevAntiPattern(new IAntiPatternDataSource.AntiPatternCallback() {
            @Override
            public void onSuccess(List<AntiPattern> data) {
                List<AntiPattern> selectedAntiPattern = new ArrayList<>();
                for(AntiPattern antiPattern : data) {
                    for (Map.Entry<Integer, Integer> entry : answerMaps.entrySet()) {
                        if (antiPattern.getId() == Integer.parseInt(String.valueOf(entry.getKey()))){
                            selectedAntiPattern.add(antiPattern);
                        }
                    }
                }

                view.setListAntiPattern(selectedAntiPattern);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    @Override
    public void getAnsweredQuestion() {
        answerMaps = (HashMap<Integer, Integer>) SharedPrefUtils.getObjectSharedPref(sharedPrefKey, null, HashMap.class);
    }

    @Override
    public boolean isAnsweredQuestionnaire() {
        return answerMaps != null && !answerMaps.isEmpty();
    }
}