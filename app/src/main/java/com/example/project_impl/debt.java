package com.example.project_impl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class debt extends AppCompatActivity {
    ImageButton debt_in,debt_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt);
        debt_in = (ImageButton) findViewById(R.id.debt_in);
        debt_out = (ImageButton) findViewById(R.id.debt_out);


        debt_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(debt.this, R.string.debt_in, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(debt.this, debt_in.class);
                startActivity(intent);
            }
        });

        debt_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(debt.this, R.string.debt_out, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(debt.this, debt_out.class);
                startActivity(intent);

            }
        });
    }
}