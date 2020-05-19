package com.gopmgo.module.refactored_solution;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.gopmgo.R;
import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentRefactoredSolutionBinding;


public class RefactoredSolutionFragment extends BaseFragment implements IRefactoredSolutionView {

    private static IRefactoredSolutionPresenter presenter;

    private FragmentRefactoredSolutionBinding binding;


    public RefactoredSolutionFragment() {
        // Fragment Constructor
    }

    public static void injectIRefactoredSolutionPresenter(IRefactoredSolutionPresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRefactoredSolutionBinding.inflate(inflater, container, false);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
            }
        });

        binding.tvDetailBandAid.setText(Html.fromHtml(getResources().getString(R.string.text_bandaid_refactored_solution)));
        binding.tvDetailSelfRepair.setText(Html.fromHtml(getResources().getString(R.string.text_selfrepair_refactored_solution)));
        binding.tvDetailRefactoring.setText(Html.fromHtml(getResources().getString(R.string.text_refactoring_solution)));
        binding.appbarToolbar.tvTitleActionBar.setText(getResources().getString(R.string.action_bar_title_refactored_solution));

        return binding.getRoot();
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