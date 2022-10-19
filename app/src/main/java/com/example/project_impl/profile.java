package com.example.project_impl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class profile extends AppCompatActivity {

    Button save,show;
    EditText uname,uemail,uaddress,uphone_no,user_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        uname=findViewById(R.id.edt_name);
        uemail=findViewById(R.id.edt_email);
        uaddress=findViewById(R.id.edt_address);
        uphone_no=findViewById(R.id.edt_phone_no);
        user_name=findViewById(R.id.username);

        save=findViewById(R.id.btn_save);
        show=findViewById(R.id.btn_show);






        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();

            }
            private void insertData(){

                Map<String,Object> map=new HashMap<>();
                map.put("Username",uname.getText().toString());
                map.put("User_name",user_name.getText().toString());
                map.put("Email",uemail.getText().toString());
                map.put("Address",uaddress.getText().toString());
                map.put("Phone_number",uphone_no.getText().toString());

                FirebaseDatabase.getInstance().getReference().child("profile").push()
                        .setValue(map)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                Toast.makeText(profile.this, R.string.data_add_message, Toast.LENGTH_SHORT).show();


                            }

                        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(profile.this, R.string.error_message, Toast.LENGTH_SHORT).show();
                    }
                });


            }

        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),showprofile.class);
                startActivity(intent);
            }
        });

















    }
}