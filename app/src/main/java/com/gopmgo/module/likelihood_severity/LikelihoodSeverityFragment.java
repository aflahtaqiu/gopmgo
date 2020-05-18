package com.gopmgo.module.likelihood_severity;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.gopmgo.R;
import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentLikelihoodSeverityBinding;


public class LikelihoodSeverityFragment extends BaseFragment implements ILikelihoodSeverityView {

    private static ILikelihoodSeverityPresenter presenter;

    private FragmentLikelihoodSeverityBinding binding;


    public LikelihoodSeverityFragment() {
        // Fragment Constructor
    }

    public static void injectILikelihoodSeverityPresenter(ILikelihoodSeverityPresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLikelihoodSeverityBinding.inflate(inflater, container, false);

        binding.appbarToolbar.tvTitleActionBar.setText(getResources().getString(R.string.actionbar_title_likelihood_severity));
        binding.tvDetail2.setText(Html.fromHtml(getResources().getString(R.string.text_detail2_likelihood_severity)));
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
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