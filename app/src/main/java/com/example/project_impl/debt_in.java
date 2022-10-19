package com.example.project_impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import android.widget.ImageButton;


import android.os.Build;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Looper;
import android.content.IntentSender;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import androidx.core.app.ActivityCompat;


import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class debt_in extends AppCompatActivity {
    Button add_1 ,view_1, Add_Image_1;
    TextInputEditText deb_amount_1,deb_description_1,deb_date_1;

    ImageView deb_reciept_pic_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_in);

        add_1=findViewById(R.id.Add_yoyo1);
        view_1=findViewById(R.id.View_yoyo);
        deb_amount_1=findViewById(R.id.sakura);
        deb_description_1=findViewById(R.id.naruto);
        deb_date_1=findViewById(R.id.blade);
        deb_reciept_pic_1=findViewById(R.id.Picture_yoyo);
        Add_Image_1=findViewById(R.id.Add_yoyo);


        Add_Image_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(debt_in.this)
//                        .galleryOnly().cameraOnly()
                        .crop()		//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

        add_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();

            }
        });

    }

    private void insertData(){

        Map<String,Object> map=new HashMap<>();
        map.put("Amount",deb_amount_1.getEditableText().toString());
        map.put("Describtion",deb_description_1.getEditableText().toString());
        map.put("Date",deb_date_1.getEditableText().toString());
        map.put("Reciept",deb_reciept_pic_1.toString());
        FirebaseDatabase.getInstance().getReference().child("debt").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(debt_in.this, R.string.data_add_message, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(debt_in.this, R.string.error_message, Toast.LENGTH_SHORT).show();
                    }
                });

        view_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),debt_showlist.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();
        deb_reciept_pic_1.setImageURI(uri);

    }

}