package com.example.project_impl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class credit extends AppCompatActivity {
    ImageButton pension, rent, salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        pension = (ImageButton) findViewById(R.id.imageButton2);
        rent = (ImageButton) findViewById(R.id.imageButton8);
        salary = (ImageButton) findViewById((R.id.imageButton10));


        pension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(credit.this, credit_add.class);
                startActivity(intent);
            }
        });

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(credit.this, credit_add.class);
                startActivity(intent);
            }
        });

        salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(credit.this, credit_add.class);
                startActivity(intent);
            }
        });


    }
}