package com.example.project_impl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    CardView credit,debit,debt;
    FloatingActionButton floatingActionButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        credit=findViewById(R.id.cre);
        debit=findViewById(R.id.deb);
        debt=findViewById(R.id.debt);

        floatingActionButton=findViewById(R.id.floatingActionButton1);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.setDrawerListener(toogle);
        toogle.syncState();
credit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(home.this,credit.class);
        startActivity(intent);
    }
});
debit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(home.this,debit.class);
        startActivity(intent);
    }
});
debt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(home.this,debt.class);
        startActivity(intent);
    }
});
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home.this,credit_add.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        int id = item.getItemId();
        if (id == R.id.history) {
            Intent intent=new Intent(home.this,History.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.setting) {
            Intent intent=new Intent(home.this,settings.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), R.string.Setting_clicked, Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.search) {
            Toast.makeText(getApplicationContext(), R.string.Click_Search, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.exit) {
            Intent intent=new Intent(home.this,exit.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.about) {
            Intent intent=new Intent(home.this,about.class);
            startActivity(intent);
            return true;
        }

        return true;



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Intent intent=new Intent(home.this,home.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_credit) {
            Intent intent=new Intent(home.this,credit_add.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), R.string.Clicked_Credit, Toast.LENGTH_SHORT).show();
            return true;

        }
        else if (id == R.id.nav_debit) {
            Intent intent=new Intent(home.this,add_debit.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), R.string.Clicked_Debit, Toast.LENGTH_SHORT).show();
            return true;

        }
        else if (id == R.id.nav_debt) {
            Intent intent=new Intent(home.this,debt.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), R.string.Clicked_Debt, Toast.LENGTH_SHORT).show();
            return true;

        }

        else if (id == R.id.nav_report) {

            Toast.makeText(getApplicationContext(), R.string.Report, Toast.LENGTH_SHORT).show();
            return true;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }


    }
}