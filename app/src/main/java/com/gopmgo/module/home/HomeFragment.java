package com.gopmgo.module.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentHomeBinding;


public class HomeFragment extends BaseFragment implements IHomeView {

    private static IHomePresenter presenter;

    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Fragment Constructor
    }

    public static void injectIHomePresenter(IHomePresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding.btnStartQuestDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(HomeFragmentDirections
                        .actionHomeFragmentToQuestDevActivity());
            }
        });

        binding.btnStartQuestPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(HomeFragmentDirections
                        .actionHomeFragmentToQuestPmActivity());
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
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