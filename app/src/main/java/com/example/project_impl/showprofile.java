package com.example.project_impl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class showprofile extends AppCompatActivity {
    EditText uname,uemail,uaddress,uphone_no ,user_name;
    FirebaseDatabase mDatabase;
    DatabaseReference ref;
    TextView change_pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showprofile);


         change_pro=findViewById(R.id.profile);
        uname=findViewById(R.id.edt_name);
        uemail=findViewById(R.id.edt_email);
        uaddress=findViewById(R.id.edt_address);
        user_name=findViewById(R.id.username);
        uphone_no=findViewById(R.id.edt_phone_no);
        mDatabase=FirebaseDatabase.getInstance();
        ref=mDatabase.getReference().child("profile");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds: snapshot.getChildren()){

                    model mod=ds.getValue(model.class);
                    String name = mod.getUsername();
                    String email =mod.getEmail();
                    String address = mod.getAddress();
                    String phone_no = mod.getPhone_number();
                    String users_name= mod.getUser_name();


                    uname.setText(name);
                    uemail.setText(email);
                    uaddress.setText(address);
                    uphone_no.setText(phone_no);
                    user_name.setText(users_name);




                }





            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(showprofile.this, R.string.Data_Fail, Toast.LENGTH_SHORT).show();
            }
        });


change_pro.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(showprofile.this,profile.class);
        startActivity(intent);
    }
});



    }
}