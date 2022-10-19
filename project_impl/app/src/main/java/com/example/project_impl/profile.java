package com.example.project_impl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button edit1,edit2,edit3,edit4;

        edit1=findViewById(R.id.button0);
        edit2=findViewById(R.id.button1);
        edit3=findViewById(R.id.button2);
        edit4=findViewById(R.id.button3);

        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "edit name", Toast.LENGTH_SHORT).show();
            }
        });

        edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "edit phone number", Toast.LENGTH_SHORT).show();
            }
        });
        edit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "edit email", Toast.LENGTH_SHORT).show();
            }
        });
        edit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "edit address", Toast.LENGTH_SHORT).show();
            }
        });
    }
}