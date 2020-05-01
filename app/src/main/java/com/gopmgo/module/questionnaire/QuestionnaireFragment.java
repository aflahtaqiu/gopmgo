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
import com.gopmgo.model.Questionnaire;

import java.util.List;


public class QuestionnaireFragment extends BaseFragment implements IQuestionnaireView, IQuestAdapterListener {

    private static IQuestionnairePresenter presenter;
    private static IQuestionnaireAdapter adapter;

    private FragmentQuestionnaireBinding binding;

    private String roleQuest;

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

        adapter.setContext(getContext());
        adapter.setListener(this);

        binding.rvQuestionnaire.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setAdapter(binding.rvQuestionnaire);
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
    public void setListQuestionnaires(List<Questionnaire> identifications) {
        adapter.updateData(identifications);
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

    public static void setAdapter(IQuestionnaireAdapter _iAdapter) {
        adapter = _iAdapter;
    }

    @Override
    public void onQuestSelected(int idQuest, int answer) {
        presenter.saveAnswer(idQuest, answer);
    }
}