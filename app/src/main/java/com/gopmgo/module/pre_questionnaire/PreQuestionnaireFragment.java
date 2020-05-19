package com.gopmgo.module.pre_questionnaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.gopmgo.R;
import com.gopmgo.base.BaseFragment;
import com.gopmgo.databinding.FragmentPreQuestionnaireBinding;


public class PreQuestionnaireFragment extends BaseFragment implements IPreQuestionnaireView {

    private static IPreQuestionnairePresenter presenter;

    private FragmentPreQuestionnaireBinding binding;

    private String roleQuest;

    public PreQuestionnaireFragment() {
        // Fragment Constructor
    }

    public static void injectIPreQuestionnairePresenter(IPreQuestionnairePresenter _presenter) {
        presenter = _presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPreQuestionnaireBinding.inflate(inflater, container, false);
        injectPresenter();

        roleQuest = PreQuestionnaireFragmentArgs.fromBundle(getArguments()).getRoleQuest();

        binding.btnStartQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(PreQuestionnaireFragmentDirections.
                        actionPreQuestionnaireFragmentToQuestionnaireFragment2(roleQuest));
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        if (roleQuest.equalsIgnoreCase(getString(R.string.role_quest_dev))) {
            setViewData(R.drawable.img_pre_quest_dev, R.string.title_pre_quest_dev, R.string.text_pre_quest_dev);
        } else {
            setViewData(R.drawable.img_pre_quest_pm, R.string.title_pre_quest_pm, R.string.text_pre_quest_pm);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setViewData (int idImage, int idTitleString, int idTextString) {
        binding.ivPreQuest.setImageResource(idImage);
        binding.tvTitlePreQuest.setText(getString(idTitleString));
        binding.tvTextPreQuest.setText(getString(idTextString));
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