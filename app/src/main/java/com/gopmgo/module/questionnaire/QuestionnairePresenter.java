package com.gopmgo.module.questionnaire;

import android.content.Context;

import com.gopmgo.data.source.IQuestionnaireDataSource;
import com.gopmgo.di.IDataInjector;
import com.gopmgo.model.Questionnaire;

import java.util.ArrayList;
import java.util.List;


public class QuestionnairePresenter implements IQuestionnairePresenter {

    private IQuestionnaireView view;
    private static QuestionnairePresenter instance;
    private static IDataInjector dataInjector;

    private String devRoleQuest = "dev";
    private String pmRoleQuest = "pm";

    private List<String> questions = new ArrayList<>();
    private List<String> showingQuestions = new ArrayList<>();

    private int maxQuestionneire;

    public static QuestionnairePresenter getInstance () {
        if(instance == null) {
            instance = new QuestionnairePresenter();
        }
        return instance;
    }

    @Override
    public void injectView(IQuestionnaireView _view) {
        view =_view;
    }

    @Override
    public void getQuestionnaires(Context context, String roleQuest) {
        if (roleQuest.equalsIgnoreCase(devRoleQuest)) {
            dataInjector.provideQuestionnaireRepository(context).getDevQuestionnaires(
                    new IQuestionnaireDataSource.QuestionnaireCallback() {
                        @Override
                        public void onSuccess(List<Questionnaire> data) {
                            setInitialData(data);
                        }

                        @Override
                        public void onError(String errorMessage) {

                        }
                    });
        } else if (roleQuest.equalsIgnoreCase(pmRoleQuest)) {
            dataInjector.provideQuestionnaireRepository(context).getPmQuestionnaires(new IQuestionnaireDataSource.QuestionnaireCallback() {
                @Override
                public void onSuccess(List<Questionnaire> data) {
                    setInitialData(data);
                }

                @Override
                public void onError(String errorMessage) {

                }
            });
        }
    }

    @Override
    public void updateQuestionnaires() {
        view.setProgress(maxQuestionneire - questions.size());
        view.setFilledQuestionnaire(maxQuestionneire - questions.size());

        if (questions.size() > 0) {
            showingQuestions.clear();

            int maxCount = questions.size() > 3 ? 2 : questions.size()-1;
            for (int i=maxCount;i>=0;i--) {
                showingQuestions.add(questions.get(i));
                questions.remove(i);
            }

            view.setListQuestionnaires(showingQuestions);
            showingQuestions.clear();
        } else {
            view.showMessage("The questionnaire has done.");
        }
    }

    void setInitialData (List<Questionnaire> data) {
        for (Questionnaire questionnaire : data) {
            questions.add(questionnaire.getIdentification());
        }

        for (int i=0;i<3;i++) {
            showingQuestions.add(questions.get(i));
            questions.remove(i);
        }

        view.setListQuestionnaires(showingQuestions);
        maxQuestionneire = data.size();
        view.setMaxQuestionnaire(data.size());

        showingQuestions.clear();
    }

    public static void setDataInjector(IDataInjector _datInjector) {
            dataInjector = _datInjector;
    }
}