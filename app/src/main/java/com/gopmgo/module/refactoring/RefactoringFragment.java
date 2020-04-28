package com.gopmgo.module.refactoring;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentRefactoringBinding;
import com.gopmgo.module.detail_antipattern.DetailAntipatternFragmentDirections;


public class RefactoringFragment extends BaseFragment implements IRefactoringView {

    private static IRefactoringPresenter presenter;

    private FragmentRefactoringBinding binding;


    public RefactoringFragment() {
        // Fragment Constructor
    }

    public static void injectIRefactoringPresenter(IRefactoringPresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRefactoringBinding.inflate(inflater, container, false);

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