package com.example.zorkoadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.zorkoadmin.fragments.AddItemFragment;
import com.example.zorkoadmin.fragments.AddUserFragment;
import com.example.zorkoadmin.fragments.HomeFragment;
import com.example.zorkoadmin.fragments.ProfileFragment;
import com.example.zorkoadmin.fragments.ViewMenuFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private View fragmentContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
                fragmentContainerView = findViewById(R.id.fragmentContainerView);
                bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int itemId = item.getItemId();

                        if(itemId== R.id.homeFragment){
                            loadFragment(new HomeFragment());
                        }
                        else if(itemId == R.id.addItemFragment){
                            loadFragment(new AddItemFragment());
                        }
                        else if(itemId == R.id.viewMenuFragment){
                            loadFragment(new ViewMenuFragment());
                        }
                        else if(itemId == R.id.addUserFragment){
                            loadFragment(new AddUserFragment());
                        }
                        else if(itemId == R.id.profileFragment){
                            loadFragment(new ProfileFragment());
                        }
                        return false;
                    }
                });

    }
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
        fragmentTransaction.commit();
    }
}