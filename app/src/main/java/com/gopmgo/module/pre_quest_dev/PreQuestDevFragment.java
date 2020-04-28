package com.gopmgo.module.pre_quest_dev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentPreQuestDevBinding;


public class PreQuestDevFragment extends BaseFragment implements IPreQuestDevView {

    private static IPreQuestDevPresenter presenter;

    private FragmentPreQuestDevBinding binding;


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