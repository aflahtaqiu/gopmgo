package com.gopmgo.module.result_as_dev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentResultAsDevBinding;
import com.gopmgo.model.AntiPattern;
import com.gopmgo.module.result_as_pm.IResultAsPmAdapter;

import java.util.List;


public class ResultAsDevFragment extends BaseFragment implements IResultAsDevView {

    private static IResultAsDevPresenter presenter;

    private FragmentResultAsDevBinding binding;


    public ResultAsDevFragment() {
        // Fragment Constructor
    }

    public static void injectIResultAsDevPresenter(IResultAsDevPresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultAsDevBinding.inflate(inflater, container, false);


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

    @Override
    public void showDataLayout() {

    }

    @Override
    public void hideDataLayout() {

    }

    @Override
    public void setListAntiPattern(List<AntiPattern> antiPatternList) {

    }
}