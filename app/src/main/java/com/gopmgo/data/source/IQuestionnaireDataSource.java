package com.gopmgo.data.source;

import com.gopmgo.base.IBaseCallback;
import com.gopmgo.model.Questionnaire;

import java.util.List;

public interface IQuestionnaireDataSource {
    void getDevQuestionnaires(QuestionnaireCallback callback);
    void getPmQuestionnaires(QuestionnaireCallback callback);

    interface QuestionnaireCallback extends IBaseCallback<List<Questionnaire>> {}
}