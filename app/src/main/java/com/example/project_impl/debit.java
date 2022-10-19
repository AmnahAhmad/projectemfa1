package com.example.project_impl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class debit extends AppCompatActivity {
    ImageButton travel, grocery,food,intertainment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit);
        travel = (ImageButton) findViewById(R.id.travel);
        grocery = (ImageButton) findViewById(R.id.grocery);
        intertainment = (ImageButton) findViewById(R.id.intertain);
        food = (ImageButton) findViewById(R.id.food);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(debit.this,add_debit.class);
                startActivity(intent);
            }
        });


        grocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(debit.this,add_debit.class);
                startActivity(intent);

            }
        });

        intertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(debit.this,add_debit.class);
                startActivity(intent);

            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(debit.this,add_debit.class);
                startActivity(intent);

            }
        });



    }
}