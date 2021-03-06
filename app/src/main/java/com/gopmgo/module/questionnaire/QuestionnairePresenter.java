package com.gopmgo.module.questionnaire;

import android.content.Context;

import com.aflah.libraryku.SharedPrefUtils;
import com.gopmgo.R;
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

    private String sharedPrefKey = "answered_question_";
    private int maxQuestionnaire;
    private static final int MAX_SHOWING_QUESTION = 3;
    private static final int ZERO_ITEM = 0;
    private static final int INDEX_DECREMENT = 1;

    private List<Questionnaire> questions = new ArrayList<>();
    private List<Questionnaire> showingQuestions = new ArrayList<>();
    private HashMap<Integer, Integer> answerMaps = new HashMap<>();

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

        sharedPrefKey = sharedPrefKey + roleQuest;

        if (roleQuest.equalsIgnoreCase(context.getString(R.string.role_quest_dev))) {
            dataInjector.provideQuestionnaireRepository(context).getDevQuestionnaires(
                    new IQuestionnaireDataSource.QuestionnaireCallback() {
                        @Override
                        public void onSuccess(List<Questionnaire> data) {
                            setInitialData(data);
                        }

                        @Override
                        public void onError(String errorMessage) {
                            if (errorMessage.equalsIgnoreCase(context.getString(R.string.message_timeout)))
                                getQuestionnaires(context, roleQuest);
                        }
                    });
        } else if (roleQuest.equalsIgnoreCase(context.getString(R.string.role_quest_pm))) {
            dataInjector.provideQuestionnaireRepository(context).getPmQuestionnaires(new IQuestionnaireDataSource.QuestionnaireCallback() {
                @Override
                public void onSuccess(List<Questionnaire> data) {
                    setInitialData(data);
                }

                @Override
                public void onError(String errorMessage) {
                    view.showMessage(errorMessage);
                }
            });
        }
    }

    @Override
    public void updateQuestionnaires() {

        view.setProgress(Math.abs(maxQuestionnaire - questions.size()));
        view.setFilledQuestionnaire(Math.abs(maxQuestionnaire - questions.size()));

        if (questions.size() > ZERO_ITEM) {
            showingQuestions.clear();

            int maxCount = questions.size() > MAX_SHOWING_QUESTION ? MAX_SHOWING_QUESTION-INDEX_DECREMENT : questions.size()-INDEX_DECREMENT;
            for (int i = maxCount; i >= 0; i--) {
                showingQuestions.add(questions.get(i));
                questions.remove(i);
            }

            view.setListQuestionnaires(showingQuestions);
            showingQuestions.clear();
        } else {
            saveAnswersToSP();
            view.moveDoneQuestionnaire();
        }
    }

    @Override
    public void setAnswerMap(int idQuestion, int answer) {
        if (answer >= MAX_SHOWING_QUESTION)
            answerMaps.put(idQuestion,answer);
    }

    @Override
    public void saveAnswersToSP() {
        SharedPrefUtils.setObjectSharedPref(sharedPrefKey, answerMaps);
        view.showMessage("The answered questionnaire saved.");
        sharedPrefKey = "answered_question_";
    }

    private void setInitialData(List<Questionnaire> data) {
        questions.addAll(data);

        for (int i=0; i<MAX_SHOWING_QUESTION; i++) {
            showingQuestions.add(questions.get(i));
            questions.remove(i);
        }

        maxQuestionnaire = data.size();
        view.setListQuestionnaires(showingQuestions);
        view.setMaxQuestionnaire(data.size());

        showingQuestions.clear();
    }

    public static void setDataInjector(IDataInjector _datInjector) {
            dataInjector = _datInjector;
    }
}