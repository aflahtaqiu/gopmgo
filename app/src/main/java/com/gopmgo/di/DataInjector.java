package com.gopmgo.di;

import android.content.Context;

import com.gopmgo.data.repository.AntiPatternRepository;
import com.gopmgo.data.repository.AntiPatternSolutionRepository;
import com.gopmgo.data.repository.QuestionnaireRepository;

public class DataInjector implements IDataInjector {

    private static DataInjector dataInjector;

    public static DataInjector getInstance() {
        if (dataInjector == null) {
            dataInjector = new DataInjector();
        }
        return dataInjector;
    }

    @Override
    public QuestionnaireRepository provideQuestionnaireRepository(Context context) {
        return QuestionnaireRepository.getInstance(context);
    }

    @Override
    public AntiPatternRepository provideAntiPatternRepository(Context context) {
        return AntiPatternRepository.getInstance(context);
    }

    @Override
    public AntiPatternSolutionRepository provideSolutionRepository(Context context) {
        return AntiPatternSolutionRepository.getInstance(context);
    }
}
