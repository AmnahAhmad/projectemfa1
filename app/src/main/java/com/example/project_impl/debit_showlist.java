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

public class debit_showlist extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter_debit adapter_two;
    FloatingActionButton floatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_showlist);
        recyclerView=findViewById(R.id.recycler123);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("debit_details"), model.class)
                        .build();
        adapter_two=new Adapter_debit(options);
        recyclerView.setAdapter(adapter_two);
        floatingActionButton=findViewById(R.id.floatingActionButton23);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),add_debit.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter_two.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter_two.startListening();
    }
}