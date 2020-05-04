package com.gopmgo.module.refactoring;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentRefactoringBinding;
import com.gopmgo.model.AntiPatternSolution;
import com.gopmgo.module.detail_antipattern.DetailAntipatternFragmentDirections;
import com.gopmgo.module.detail_antipattern.ISolutionConnector;

import java.util.List;


public class RefactoringFragment extends BaseFragment implements IRefactoringView, ISolutionConnector {

    private static IRefactoringAdapter adapter;
    private static IRefactoringPresenter presenter;

    private FragmentRefactoringBinding binding;

    private int idAntiPattern;

    public RefactoringFragment(int idAntiPattern) {
        this.idAntiPattern = idAntiPattern;
    }

    public RefactoringFragment() {
    }

    public static void injectIRefactoringPresenter(IRefactoringPresenter _presenter) {
        presenter = _presenter;
    }

    public static void injectAdapter (IRefactoringAdapter _adapter){
        adapter = _adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRefactoringBinding.inflate(inflater, container, false);
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
        binding.rvRefactoring.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.setContext(getContext());
        adapter.setAdapter(binding.rvRefactoring);

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