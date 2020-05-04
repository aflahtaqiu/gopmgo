package com.gopmgo.module.self_repair;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentSelfRepairBinding;
import com.gopmgo.model.AntiPatternSolution;
import com.gopmgo.module.detail_antipattern.DetailAntipatternFragmentDirections;
import com.gopmgo.module.detail_antipattern.ISolutionConnector;

import java.util.List;


public class SelfRepairFragment extends BaseFragment implements ISelfRepairView, ISolutionConnector {

    private static ISelfRepairAdapter adapter;
    private static ISelfRepairPresenter presenter;

    private FragmentSelfRepairBinding binding;

    private int idAntiPattern;

    static void injectISelfRepairPresenter(ISelfRepairPresenter _presenter) {
        presenter = _presenter;
    }

    public static void injectAdapter (ISelfRepairAdapter _adapter) {
        adapter = _adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelfRepairBinding.inflate(inflater, container, false);
        injectPresenter();

        binding.ivQuestion.setOnClickListener(v -> Navigation.findNavController(v).navigate(DetailAntipatternFragmentDirections
                .actionDetailAntipatternFragmentToRefactoredSolutionFragment()));

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        binding.rvSelfRepair.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.setContext(getContext());
        adapter.setAdapter(binding.rvSelfRepair);

        presenter.getSolutionList(getContext(), idAntiPattern);
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

    @Override
    public void showListSolution(List<AntiPatternSolution> solutionList) {
        adapter.updateData(solutionList);
    }

    @Override
    public void setIdAntiPattern(int idAntiPattern) {
        this.idAntiPattern = idAntiPattern;
    }
}