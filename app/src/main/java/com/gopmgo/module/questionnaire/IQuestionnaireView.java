package com.gopmgo.module.questionnaire;


import com.gopmgo.base.IBaseView;

import java.util.List;

public interface IQuestionnaireView extends IBaseView {
    void injectPresenter();
    void setListQuestionnaires(List<String> identifications);
    void setMaxQuestionnaire(int maxValue);
    void setFilledQuestionnaire(int value);
    void setProgress(int progress);
}