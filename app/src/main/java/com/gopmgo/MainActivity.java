package com.gopmgo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
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

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.resultAsPmFragment, R.id.resultAsDevFragment)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getId()) {
                case R.id.homeFragment:
                case R.id.resultAsPmFragment:
                case R.id.resultAsDevFragment:
                    showBottomNavigation(); break;
                default: hideBottomNavigation();
            }
//            getSupportActionBar().setTitle(destination.getLabel());
        });

//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String roleQuest = getIntent().getStringExtra("roleQuest");

        if (roleQuest == null) {
            navView.setSelectedItemId(R.id.homeFragment);
        }
        else{
            if (roleQuest.equalsIgnoreCase("dev"))
                navView.setSelectedItemId(R.id.resultAsDevFragment);
            else if (roleQuest.equalsIgnoreCase("pm"))
                navView.setSelectedItemId(R.id.resultAsPmFragment);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
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
