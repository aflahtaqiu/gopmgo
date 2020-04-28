package com.gopmgo;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.resultAsPmFragment, R.id.resultAsDevFragment)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    private void hideBottomNavigation() {

        if (navView.getVisibility() == View.VISIBLE && navView.getAlpha() == 1f) {
            navView.animate().alpha(0f)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            navView.setVisibility(View.GONE);
                        }
                    }).setDuration(500);
        }
    }

    private void showBottomNavigation() {
        // navigation is BottomNavigationView
        navView.setVisibility(View.VISIBLE);
        navView.animate().alpha(1f).setDuration(500);
    }
}
