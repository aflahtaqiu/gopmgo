package com.gopmgo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

     private BottomNavigationView navView;

     private static final int animDuration = 0;
     private static final float alphaShow = 1f;
    private static final float alphaHide = 0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getId()) {
                case R.id.homeFragment:
                case R.id.resultAsPmFragment:
                case R.id.resultAsDevFragment:
                    showBottomNavigation(); break;
                default: hideBottomNavigation();
            }
        });

        NavigationUI.setupWithNavController(navView, navController);
    }

    private void hideBottomNavigation() {
        if (navView.getVisibility() == View.VISIBLE && navView.getAlpha() == alphaShow) {
            navView.animate().alpha(alphaHide)
                    .withEndAction(() -> navView.setVisibility(View.GONE)).setDuration(animDuration);
        }
    }

    private void showBottomNavigation() {
        navView.setVisibility(View.VISIBLE);
        navView.animate().alpha(alphaShow).setDuration(animDuration);
    }
}
