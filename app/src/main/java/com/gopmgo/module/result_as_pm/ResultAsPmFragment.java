package com.gopmgo.module.result_as_pm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentResultAsPmBinding;
import com.gopmgo.model.AntiPattern;

import java.util.List;


public class ResultAsPmFragment extends BaseFragment implements IResultAsPmView {

    private static IResultAsPmPresenter presenter;
    private static IResultAsPmAdapter adapter;

    private FragmentResultAsPmBinding binding;


    public ResultAsPmFragment() {
        // Fragment Constructor
    }

    public static void injectIResultAsPmPresenter(IResultAsPmPresenter _presenter) {
        presenter = _presenter;
    }

    public static void injectAdapter (IResultAsPmAdapter _adapter) {
        adapter = _adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultAsPmBinding.inflate(inflater, container, false);
        injectPresenter();

        binding.rvResultPm.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.tvDetailLikelihoodSeverity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(ResultAsPmFragmentDirections
                        .actionResultAsPmFragmentToLikelihoodSeverityFragment());
            }
        });

        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(ResultAsPmFragmentDirections.actionResultAsPmFragmentToDetailAntipatternFragment2());
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        presenter.getAnsweredQuestion();

        if (presenter.isAnsweredQuestionnaire()) {
            configAdapter();
            showDataLayout();
            presenter.getAntiPatterns(getContext());
        } else {
            hideDataLayout();
        }
        super.onResume();
    }

    private void configAdapter() {
        adapter.setContext(getContext());
//        adapter.setListener(this);
        adapter.setAdapter(binding.rvResultPm);
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
        binding.layoutDataIsEmpty.setVisibility(View.GONE);
        binding.layoutDataNoEmpty.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDataLayout() {
        binding.layoutDataNoEmpty.setVisibility(View.GONE);
        binding.layoutDataIsEmpty.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListAntiPattern(List<AntiPattern> antiPatternList) {
        adapter.updateData(antiPatternList);
    }
}