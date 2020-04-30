package com.gopmgo.module.questionnaire;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentQuestionnaireBinding;


public class QuestionnaireFragment extends BaseFragment implements IQuestionnaireView {

    private static IQuestionnairePresenter presenter;

    private FragmentQuestionnaireBinding binding;

    private String roleQuest;
    private int progress = 0;
    private Handler handler = new Handler();

    public QuestionnaireFragment () {
        // Fragment Constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding = FragmentQuestionnaireBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        roleQuest = QuestionnaireFragmentArgs.fromBundle(getArguments()).getROLEQUEST();
        binding.progressbarQuestionnaire.setProgress(50);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
//        presenter.getQuestionnaires(getContext());
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void showLoading(String message) {
        super.onShowLoading(message);
    }

    @Override
    public void hideLoading() {
        super.onHideLoading();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void injectPresenter() {
        presenter.injectView(this);
    }

    public static void injectIQuestionnairePresenter (IQuestionnairePresenter _presenter) {
        presenter = _presenter;
    }
}