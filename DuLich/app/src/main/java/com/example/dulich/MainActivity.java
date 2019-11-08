package com.example.dulich;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.titlebar);
        textView = findViewById(R.id.titleBar);
        textView.setText("Travel Assistant");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new listTours()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.navigation_home:
                    selectedFragment = new listTours();

                    textView.setText("Travel Assistant");
                    break;
                case R.id.navigation_history:
                    selectedFragment = new tourDetail();

                    textView.setText("Tour Detail");
                    break;
                case R.id.navigation_map:
                    selectedFragment = new map();
                    textView.setText("Map");
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new notifications();

                    textView.setText("Notifications");
                    break;
                case R.id.navigation_setting:
                    selectedFragment = new setting();

                    textView.setText("Setting");
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,selectedFragment).commit();
            return true;
        }
    };
}
