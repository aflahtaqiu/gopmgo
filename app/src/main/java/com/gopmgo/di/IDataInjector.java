package com.gopmgo.di;


import android.content.Context;

import com.gopmgo.data.repository.QuestionnaireRepository;

public interface IDataInjector {
    QuestionnaireRepository provideQuestionnaireRepository (Context context);
}
