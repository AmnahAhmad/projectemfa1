package com.example.project_impl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class debt_showlist extends AppCompatActivity {
    RecyclerView recyclerView;
    debt_adapter adapter_debt_in;
    FloatingActionButton floatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_showlist);
        recyclerView=findViewById(R.id.recycler148);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("debt"), model.class)
                        .build();
        adapter_debt_in=new debt_adapter(options);
        recyclerView.setAdapter(adapter_debt_in);
        floatingActionButton=findViewById(R.id.floatingActionButton3);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),debt_in.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter_debt_in.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter_debt_in.stopListening();
    }
}
