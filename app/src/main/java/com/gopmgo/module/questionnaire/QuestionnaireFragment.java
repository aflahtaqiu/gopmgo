package com.gopmgo.module.questionnaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.DialogConfirmationBinding;
import com.gopmgo.databinding.FragmentQuestionnaireBinding;
import com.gopmgo.model.Questionnaire;

import java.util.List;


public class QuestionnaireFragment extends BaseFragment implements IQuestionnaireView, IQuestAdapterListener {

    private static IQuestionnairePresenter presenter;
    private static IQuestionnaireAdapter adapter;

    private FragmentQuestionnaireBinding binding;

    private String roleQuest;
    private static final int FIRST_LIST_POSITION_INDEX = 0;

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
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();

                DialogConfirmationBinding bindingDialog = DialogConfirmationBinding.inflate(LayoutInflater.from(getContext()));
                alertDialog.setView(bindingDialog.getRoot());

                bindingDialog.btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        Navigation.findNavController(binding.getRoot()).
                                navigate(QuestionnaireFragmentDirections
                                        .actionQuestionnaireFragment2ToHomeFragment());
                    }
                });

                bindingDialog.btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
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
        roleQuest = QuestionnaireFragmentArgs.fromBundle(getArguments()).getRoleQuest();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        presenter.getQuestionnaires(getContext(), roleQuest);

        binding.rvQuestionnaire.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.setContext(getContext());
        adapter.setListener(this);
        adapter.setAdapter(binding.rvQuestionnaire);
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        binding = null;
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
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void injectPresenter() {
        presenter.injectView(this);
    }

    @Override
    public void setListQuestionnaires(List<Questionnaire> identifications) {
        adapter.updateData(identifications);
        binding.rvQuestionnaire.scrollToPosition(FIRST_LIST_POSITION_INDEX);
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

    @Override
    public void moveDoneQuestionnaire() {
        Navigation.findNavController(binding.getRoot()).navigate(QuestionnaireFragmentDirections.actionQuestionnaireFragment2ToDoneQuestionnaireFragment2(roleQuest));
    }

    public static void injectIQuestionnairePresenter (IQuestionnairePresenter _presenter) {
        presenter = _presenter;
    }

    public static void setAdapter(IQuestionnaireAdapter _iAdapter) {
        adapter = _iAdapter;
    }

    @Override
    public void onQuestSelected(int idQuest, int answer) {
        presenter.setAnswerMap(idQuest, answer);
    }
}