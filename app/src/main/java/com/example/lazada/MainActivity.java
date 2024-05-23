package com.example.lazada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.lazada.fragment.CartFragment;
import com.example.lazada.fragment.HomeFragment;
import com.example.lazada.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Lazada);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        showFragment(HomeFragment.class);

        bottomNavigationView.setOnItemSelectedListener(item ->{
            switch (item.getItemId()) {
                case R.id.nav_home: return showFragment(HomeFragment.class);
                case R.id.nav_cart: return showFragment(CartFragment.class);
                case R.id.nav_settings: return showFragment(SettingsFragment.class);
                default:
                    Log.d("Error", "Error");
                    return false;
            }
        });
    }

    protected boolean showFragment(Class<? extends Fragment> theClass){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container,theClass,null)
                .setReorderingAllowed(true)
                .commit();
        return true;
    }
}