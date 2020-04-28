package com.gopmgo.module.band_aid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentBandAidBinding;
import com.gopmgo.module.detail_antipattern.DetailAntipatternFragmentDirections;


public class BandAidFragment extends BaseFragment implements IBandAidView {

    private static IBandAidPresenter presenter;

    private FragmentBandAidBinding binding;


    public BandAidFragment() {
        // Fragment Constructor
    }

    public static void injectIBandAidPresenter(IBandAidPresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBandAidBinding.inflate(inflater, container, false);

        binding.ivQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(DetailAntipatternFragmentDirections
                        .actionDetailAntipatternFragmentToRefactoredSolutionFragment());
            }
        });

//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("true");
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