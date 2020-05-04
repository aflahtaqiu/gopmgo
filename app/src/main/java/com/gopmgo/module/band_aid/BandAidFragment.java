package com.gopmgo.module.band_aid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentBandAidBinding;
import com.gopmgo.model.AntiPatternSolution;
import com.gopmgo.module.detail_antipattern.DetailAntipatternFragmentDirections;

import java.util.List;


public class BandAidFragment extends BaseFragment implements IBandAidView {

    private static IBandAidPresenter presenter;
    private static IBandAidAdapter adapter;

    private FragmentBandAidBinding binding;

    private int idAntiPattern;

    public BandAidFragment(int idAntiPattern) {
        this.idAntiPattern = idAntiPattern;
    }

    public static void injectIBandAidPresenter(IBandAidPresenter _presenter) {
        presenter = _presenter;
    }

    public static void injectAdapter (IBandAidAdapter _adapter) {
        adapter = _adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBandAidBinding.inflate(inflater, container, false);
        injectPresenter();

        binding.ivQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(DetailAntipatternFragmentDirections
                        .actionDetailAntipatternFragmentToRefactoredSolutionFragment());
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        binding.rvBandAidSolution.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.setContext(getContext());
        adapter.setAdapter(binding.rvBandAidSolution);

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
}