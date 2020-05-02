package com.gopmgo.module.done_questionnaire;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.aflah.libraryku.SharedPrefUtils;
import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentDoneQuestionnaireBinding;

import java.util.HashMap;
import java.util.Map;


public class DoneQuestionnaireFragment extends BaseFragment implements IDoneQuestionnaireView {

    private static IDoneQuestionnairePresenter presenter;

    private FragmentDoneQuestionnaireBinding binding;
    private String devRoleQuest = "dev";
    private String pmRoleQuest = "pm";

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
                        .actionDoneQuestionnaireFragmentToResultAsPmFragment2());
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        HashMap<Integer, Integer> answerMaps = (HashMap<Integer, Integer>) SharedPrefUtils.getObjectSharedPref("answered_question", null, HashMap.class);
        for (Map.Entry<Integer, Integer> entry : answerMaps.entrySet()) {
            Log.e("lele", "soal: " + entry.getKey() + "; jawaban: " + entry.getValue());
        }
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