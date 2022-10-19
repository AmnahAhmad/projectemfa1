package com.example.project_impl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class credit extends AppCompatActivity {
    ImageButton Pension, Rent, Salary,Business;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        Pension = (ImageButton) findViewById(R.id.pension);
        Rent = (ImageButton) findViewById(R.id.rent);
        Salary = (ImageButton) findViewById(R.id.salary);
        Business=(ImageButton) findViewById(R.id.business);


        Pension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(credit.this, R.string.Pension_category, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(credit.this, credit_add.class);
                startActivity(intent);
            }
        });

        Rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(credit.this, R.string.Rent_category, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(credit.this, credit_add.class);
                startActivity(intent);
            }
        });

        Salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(credit.this, R.string.Salary_category, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(credit.this, credit_add.class);
                startActivity(intent);
            }
        });
        Business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(credit.this, R.string.Business_category, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(credit.this, credit_add.class);
                startActivity(intent);
            }
        });


    }
}