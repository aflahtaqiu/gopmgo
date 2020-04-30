package com.gopmgo.module.pre_quest_dev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentPreQuestDevBinding;


public class PreQuestDevFragment extends BaseFragment implements IPreQuestDevView {

    private static IPreQuestDevPresenter presenter;

    private FragmentPreQuestDevBinding binding;

    private String devRoleQuest = "dev";


    public PreQuestDevFragment() {
        // Fragment Constructor
    }

    public static void injectIPreQuestDevPresenter(IPreQuestDevPresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPreQuestDevBinding.inflate(inflater, container, false);
        binding.btnStartQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(PreQuestDevFragmentDirections
                        .actionPreQuestDevFragmentToQuestionnaireFragment(devRoleQuest));
            }
        });

        return binding.getRoot();
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