package com.gopmgo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
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
        if (navView.getVisibility() == View.VISIBLE && navView.getAlpha() == 1f) {
            navView.animate().alpha(0f)
                    .withEndAction(() -> navView.setVisibility(View.GONE)).setDuration(0);
        }
    }

    private void showBottomNavigation() {
        navView.setVisibility(View.VISIBLE);
        navView.animate().alpha(1f).setDuration(0);
    }
}
