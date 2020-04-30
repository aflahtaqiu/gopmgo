package com.gopmgo.module.questionnaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentQuestionnaireBinding;

import java.util.ArrayList;
import java.util.List;


public class QuestionnaireFragment extends BaseFragment implements IQuestionnaireView {

    private static IQuestionnairePresenter presenter;

    private FragmentQuestionnaireBinding binding;

    private String roleQuest;

    private List<String> questions = new ArrayList<>();
    private QuestionnaireAdapter adapter;

    public QuestionnaireFragment () {
        // Fragment Constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding = FragmentQuestionnaireBinding.inflate(inflater, container, false);
        injectPresenter();

        binding.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(QuestionnaireFragmentDirections.
                        actionQuestionnaireFragmentToMobileNavigation2());
            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateQuestionnaires();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        roleQuest = QuestionnaireFragmentArgs.fromBundle(getArguments()).getROLEQUEST();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        presenter.getQuestionnaires(getContext(), roleQuest);

        adapter = new QuestionnaireAdapter(questions, getContext());
        binding.rvQuestionnaire.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvQuestionnaire.setAdapter(adapter);
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        binding = null;
        adapter = null;
        super.onDestroyView();
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

    @Override
    public void setListQuestionnaires(List<String> identifications) {
        questions.clear();
        questions.addAll(identifications);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void setMaxQuestionnaire(int maxValue) {
        binding.tvMaxQuest.setText(String.valueOf(maxValue));
        binding.progressbarQuestionnaire.setMax(maxValue);
    }

    @Override
    public void setFilledQuestionnaire(int value) {
        binding.tvFilledQuest.setText(String.valueOf(value));
    }

    @Override
    public void setProgress(int progress) {
        binding.progressbarQuestionnaire.setProgress(progress);
    }

    public static void injectIQuestionnairePresenter (IQuestionnairePresenter _presenter) {
        presenter = _presenter;
    }
}