package com.gopmgo.module.result_as_dev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gopmgo.R;
import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentResultAsDevBinding;
import com.gopmgo.model.AntiPattern;

import java.util.List;


public class ResultAsDevFragment extends BaseFragment implements IResultAsDevView, IResultDevAdapterListener {

    private static IResultAsDevAdapter adapter;
    private static IResultAsDevPresenter presenter;

    private FragmentResultAsDevBinding binding;


    public ResultAsDevFragment() {
        // Fragment Constructor
    }

    public static void injectIResultAsDevPresenter(IResultAsDevPresenter _presenter) {
        presenter = _presenter;
    }

    public static void injectAdapter (IResultAsDevAdapter _adapter) {
        adapter = _adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultAsDevBinding.inflate(inflater, container, false);
        injectPresenter();

        binding.appbarToolbar.tvTitleActionBar.setText(getResources().getString(R.string.action_bar_title_dev_result));
        binding.rvResultDev.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.tvDetailLikelihoodSeverity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(ResultAsDevFragmentDirections
                        .actionResultAsDevFragmentToLikelihoodSeverityFragment());
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
        adapter.setListener(this);
        adapter.setAdapter(binding.rvResultDev);
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

    @Override
    public void onItemClicked(int idAntiPattern, String title) {
        Navigation.findNavController(binding.getRoot()).navigate(ResultAsDevFragmentDirections
                .actionResultAsDevFragmentToDetailAntipatternFragment2(idAntiPattern, title));
    }
}