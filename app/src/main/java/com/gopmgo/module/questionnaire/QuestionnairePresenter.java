package com.gopmgo.module.questionnaire;

import android.content.Context;

import com.aflah.libraryku.SharedPrefUtils;
import com.gopmgo.data.source.IQuestionnaireDataSource;
import com.gopmgo.di.IDataInjector;
import com.gopmgo.model.Questionnaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class QuestionnairePresenter implements IQuestionnairePresenter {

    private IQuestionnaireView view;
    private static QuestionnairePresenter instance;
    private static IDataInjector dataInjector;

    private String devRoleQuest = "dev";
    private String pmRoleQuest = "pm";

    private List<Questionnaire> questions = new ArrayList<>();
    private List<Questionnaire> showingQuestions = new ArrayList<>();
    private HashMap<Integer, Integer> answerMaps = new HashMap<>();

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
            saveAnswersToSP();
            view.moveDoneQuestionnaire();
            view.showMessage("The questionnaire has done.");
        }
    }

    @Override
    public void setAnswerMap(int idQuestion, int answer) {
        answerMaps.put(idQuestion,answer);
    }

    @Override
    public void saveAnswersToSP() {
        SharedPrefUtils.setObjectSharedPref("answered_question", answerMaps);
    }

    @Override
    public HashMap<Integer, Integer> storeAnswer() {
        return this.answerMaps;
    }

    void setInitialData (List<Questionnaire> data) {
        for (Questionnaire questionnaire : data) {
            questions.add(questionnaire);
        }

        for (int i=0;i<3;i++) {
            showingQuestions.add(questions.get(i));
            questions.remove(i);
        }

        maxQuestionneire = data.size();
        view.setListQuestionnaires(showingQuestions);
        view.setMaxQuestionnaire(data.size());

        showingQuestions.clear();
    }

    public static void setDataInjector(IDataInjector _datInjector) {
            dataInjector = _datInjector;
    }
}