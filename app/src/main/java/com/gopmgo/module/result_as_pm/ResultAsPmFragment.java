package com.gopmgo.module.result_as_pm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentResultAsPmBinding;


public class ResultAsPmFragment extends BaseFragment implements IResultAsPmView {

    private static IResultAsPmPresenter presenter;

    private FragmentResultAsPmBinding binding;


    public ResultAsPmFragment() {
        // Fragment Constructor
    }

    public static void injectIResultAsPmPresenter(IResultAsPmPresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultAsPmBinding.inflate(inflater, container, false);


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