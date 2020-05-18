package com.gopmgo.module.detail_antipattern;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentDetailAntipatternBinding;


public class DetailAntipatternFragment extends BaseFragment implements IDetailAntipatternView {

    private static IDetailAntipatternPresenter presenter;
    private static IFragmentAdapter adapter;

    private FragmentDetailAntipatternBinding binding;

    private int idAntiPattern;
    private String title;

    public DetailAntipatternFragment() {
        // Fragment Constructor
    }

    public static void injectIDetailAntipatternPresenter(IDetailAntipatternPresenter _presenter) {
        presenter = _presenter;
    }

    public static void injectAdapter(IFragmentAdapter _adapter){
        adapter = _adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailAntipatternBinding.inflate(inflater, container, false);

        title = DetailAntipatternFragmentArgs.fromBundle(getArguments()).getAntipatternName();
        idAntiPattern = DetailAntipatternFragmentArgs.fromBundle(getArguments()).getIDANTIPATTERN();
        adapter = new DetailAntipatternFragmentAdapter(getChildFragmentManager());

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        adapter.setIdAntiPattern(idAntiPattern);
        adapter.setViewPagerAdapter(binding.viewpagerDetailAntipattern);
        binding.appbarToolbar.tvTitleActionBar.setText(title);

        binding.tablayoutDetailAntipattern.setupWithViewPager(binding.viewpagerDetailAntipattern);

        super.onResume();
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
}