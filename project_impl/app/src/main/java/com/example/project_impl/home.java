package com.example.project_impl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class home extends AppCompatActivity {
    CardView credit,debit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        credit=findViewById(R.id.cre);
        debit=findViewById(R.id.deb);


        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.RED);
        setSupportActionBar(toolbar);
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



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.share) {
            Intent intent=new Intent(home.this,share.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.setting) {
            Intent intent=new Intent(home.this,settings.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "you click setting", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.search) {
            Toast.makeText(getApplicationContext(), "you click search", Toast.LENGTH_SHORT).show();
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
}