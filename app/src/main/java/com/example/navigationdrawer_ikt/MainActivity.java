package com.example.navigationdrawer_ikt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //Hamburger icon létrehozása
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout, toolbar, R.string.open, R.string.close);

        //Összekötés
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Ez a beállitás", Toast.LENGTH_SHORT).show();
                        //Fragment != Activity-vel tehát nem Intent-el nyitjuk meg
                        //Intent = new Intent(honnan,hova akarunk menni)
                        //fragment (frameLayout, új fragment-et nyisson meg)
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutContainer, new SettingsFragment()).commit();
                        break;
                    //TODO: és akkor ide a maradékot még
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_settings:
                        //ide is ugyan azt a funkciót írhatod, mint a navigationDrawer-nél
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutContainer, new SettingsFragment()).commit();
                        Toast.makeText(MainActivity.this, "Ez a beállítás", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_home:
                        ///ide is majd valamit
                        break;
                    //TODO: és akkor ide a maradékot még
                }
                return true;
            }
        });
    }

    public void init() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

}