package com.gopmgo.module.done_questionnaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentDoneQuestionnaireBinding;


public class DoneQuestionnaireFragment extends BaseFragment implements IDoneQuestionnaireView {

    private static IDoneQuestionnairePresenter presenter;

    private FragmentDoneQuestionnaireBinding binding;

    public DoneQuestionnaireFragment() {
        // Fragment Constructor
    }

    public static void injectIDoneQuestionnairePresenter(IDoneQuestionnairePresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDoneQuestionnaireBinding.inflate(inflater, container, false);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(DoneQuestionnaireFragmentDirections
                        .actionDoneQuestionnaireFragmentToMainActivity2());
            }
        });

        return binding.getRoot();
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