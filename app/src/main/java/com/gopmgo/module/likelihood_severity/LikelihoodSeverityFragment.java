package com.gopmgo.module.likelihood_severity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentLikelihoodSeverityBinding;


public class LikelihoodSeverityFragment extends BaseFragment implements ILikelihoodSeverityView {

    private static ILikelihoodSeverityPresenter presenter;

    private FragmentLikelihoodSeverityBinding binding;


    public LikelihoodSeverityFragment() {
        // Fragment Constructor
    }

    public static void injectILikelihoodSeverityPresenter(ILikelihoodSeverityPresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLikelihoodSeverityBinding.inflate(inflater, container, false);


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