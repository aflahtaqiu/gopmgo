package com.gopmgo.module.splash_screen;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.aflah.libraryku.CommunicationUtils;
import com.gopmgo.R;
import com.gopmgo.base.BaseActivity;
import com.gopmgo.databinding.ActivitySplashScreenBinding;


public class SplashScreenActivity extends BaseActivity implements ISplashScreenView {

    private static ISplashScreenPresenter presenter;

    private ActivitySplashScreenBinding binding;

    private static Class mainClass;

    public static void injectISplashScreenPresenter(ISplashScreenPresenter _presenter) {
        presenter = _presenter;
    }

    public static void injectDestinationClass (Class _class) {
        mainClass = _class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        binding.layoutSplashScreen.startAnimation(animFadeIn);
    }

    @Override
    protected void onStart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                CommunicationUtils.changeActivity(SplashScreenActivity.this, mainClass);
            }
        }, 3000);
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
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