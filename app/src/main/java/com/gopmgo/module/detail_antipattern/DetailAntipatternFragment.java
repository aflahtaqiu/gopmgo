package com.gopmgo.module.detail_antipattern;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentDetailAntipatternBinding;
import com.gopmgo.module.band_aid.BandAidFragment;
import com.gopmgo.module.refactoring.RefactoringFragment;
import com.gopmgo.module.self_repair.SelfRepairFragment;


public class DetailAntipatternFragment extends BaseFragment implements IDetailAntipatternView {

    private static IDetailAntipatternPresenter presenter;

    private FragmentDetailAntipatternBinding binding;


    public DetailAntipatternFragment() {
        // Fragment Constructor
    }

    public static void injectIDetailAntipatternPresenter(IDetailAntipatternPresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailAntipatternBinding.inflate(inflater, container, false);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
            }
        });

        DetailAntipatternFragmentAdapter adapter = new DetailAntipatternFragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new BandAidFragment(), "Band Aid");
        adapter.addFragment(new SelfRepairFragment(), "Self Repair");
        adapter.addFragment(new RefactoringFragment(), "Refactoring");

        binding.viewpagerDetailAntipattern.setAdapter(adapter);
        binding.tablayoutDetailAntipattern.setupWithViewPager(binding.viewpagerDetailAntipattern);

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