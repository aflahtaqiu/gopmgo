package com.gopmgo.di;


import android.content.Context;

import com.gopmgo.data.repository.AntiPatternRepository;
import com.gopmgo.data.repository.AntiPatternSolutionRepository;
import com.gopmgo.data.repository.QuestionnaireRepository;

public interface IDataInjector {
    QuestionnaireRepository provideQuestionnaireRepository (Context context);
    AntiPatternRepository provideAntiPatternRepository (Context context);
    AntiPatternSolutionRepository provideSolutionRepository (Context context);
}
