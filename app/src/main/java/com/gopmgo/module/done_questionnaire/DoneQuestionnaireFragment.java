package com.gopmgo.module.done_questionnaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.gopmgo.R;
import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentDoneQuestionnaireBinding;


public class DoneQuestionnaireFragment extends BaseFragment implements IDoneQuestionnaireView {

    private static IDoneQuestionnairePresenter presenter;
    private static Class mainClass;
    private FragmentDoneQuestionnaireBinding binding;
    private String roleQuest;

    public DoneQuestionnaireFragment() {
        // Fragment Constructor
    }

    public static void injectIDoneQuestionnairePresenter(IDoneQuestionnairePresenter _presenter) {
        presenter = _presenter;
    }

    public static void injectMainClass (Class _class){
        mainClass = _class;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDoneQuestionnaireBinding.inflate(inflater, container, false);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roleQuest.equalsIgnoreCase(getString(R.string.role_quest_dev))) {
                    Navigation.findNavController(v).navigate(DoneQuestionnaireFragmentDirections
                            .actionDoneQuestionnaireFragment2ToResultAsDevFragment());
                } else {
                    Navigation.findNavController(v).navigate(DoneQuestionnaireFragmentDirections
                            .actionDoneQuestionnaireFragment2ToResultAsPmFragment());
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        roleQuest = DoneQuestionnaireFragmentArgs.fromBundle(getArguments()).getRoleQuest();
    }

    @Override
    public void onResume() {
        super.onResume();
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
}