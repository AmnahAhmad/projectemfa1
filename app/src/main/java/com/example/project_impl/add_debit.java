package com.example.project_impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
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

public class add_debit extends AppCompatActivity implements View.OnClickListener{

    String[] modes = {"High", "Low", "Medium"};
    String[] types = {"Daily", "Monthly", "Yearly"};
    String[] choice = {"Yes", "No"};
    TextInputEditText view_calendar, Location1, amount,description;
    Button add ,show, Add_Image;
    ImageButton Location_button;
    ImageView receipt;
    private LocationRequest locationRequest1;
    private int mYear, mMonth, mDay, mHour, mMinute;
    AutoCompleteTextView priority, type,recurring_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_debit);

        view_calendar = findViewById(R.id.time);
        Location1 = findViewById(R.id.location_text);
        amount = findViewById(R.id.amount_text);
        description= findViewById(R.id.description_text);
        Location_button=findViewById(R.id.location_button);
        receipt = findViewById(R.id.bill_image);
        Add_Image = findViewById(R.id.addimage_button);
        show  = findViewById(R.id.Show_button);
        priority = (AutoCompleteTextView) findViewById(R.id.dropdown_area1);
        type = (AutoCompleteTextView) findViewById(R.id.dropdown_area_type);
        recurring_status=(AutoCompleteTextView)findViewById(R.id.dropdown_area2);
        add = findViewById((R.id.finish_button));
        view_calendar.setOnClickListener(this);
        locationRequest1 = LocationRequest.create();
        locationRequest1.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest1.setInterval(5000);
        locationRequest1.setFastestInterval(2000);

        //Creating the instance of ArrayAdapter containing list of modes
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, modes);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.dropdown_area1);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.BLACK);

        //Creating the instance of ArrayAdapter containing list of types
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, types);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv1 = (AutoCompleteTextView) findViewById(R.id.dropdown_area_type);
        actv1.setThreshold(1);//will start working from first character
        actv1.setAdapter(adapter1);//setting the adapter data into the AutoCompleteTextView
        actv1.setTextColor(Color.BLACK);

        //Creating the instance of ArrayAdapter containing list of choice
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, choice);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv2 = (AutoCompleteTextView) findViewById(R.id.dropdown_area2);
        actv2.setThreshold(1);//will start working from first character
        actv2.setAdapter(adapter2);//setting the adapter data into the AutoCompleteTextView
        actv2.setTextColor(Color.BLACK);

        //Location
        Location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (ActivityCompat.checkSelfPermission(add_debit.this
                            , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if(isGPSEnabled()){
                            LocationServices.getFusedLocationProviderClient(add_debit.this)
                                    .requestLocationUpdates(locationRequest1, new LocationCallback() {
                                        @Override
                                        public void onLocationResult(@NonNull LocationResult locationResult) {
                                            super.onLocationResult(locationResult);

                                            LocationServices.getFusedLocationProviderClient(add_debit.this)
                                                    .removeLocationUpdates(this);

                                            if (locationResult != null && locationResult.getLocations().size() >0){

                                                int index = locationResult.getLocations().size() - 1;
                                                double latitude = locationResult.getLocations().get(index).getLatitude();
                                                double longitude = locationResult.getLocations().get(index).getLongitude();

                                                Location1.setText("Latitude: "+ latitude + "\n" + "Longitude: "+ longitude);
                                            }
                                        }
                                    }, Looper.getMainLooper());

                        }else{
                            turnOnGPS();
                        }

                    } else {
                        //When Permission is Denied
                        ActivityCompat.requestPermissions(add_debit.this
                                , new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                    }
                }

            }
        });

        Add_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(add_debit.this)
//                        .galleryOnly().cameraOnly()
                        .crop()		//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();


            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == view_calendar) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog;
            datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            view_calendar.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    private void turnOnGPS() {

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest1);
        builder.setAlwaysShow(true);

        Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(getApplicationContext())
                .checkLocationSettings(builder.build());
        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {

                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                    Toast.makeText(add_debit.this, R.string.GPS_message, Toast.LENGTH_SHORT).show();

                } catch (ApiException e) {

                    switch (e.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:

                            try {
                                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                                resolvableApiException.startResolutionForResult(add_debit.this, 2);
                            } catch (IntentSender.SendIntentException ex) {
                                ex.printStackTrace();
                            }
                            break;

                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            //Device does not have location
                            break;
                    }
                }
            }
        });

    }

    private boolean isGPSEnabled(){
        LocationManager locationManager = null;
        boolean isEnabled = false;

        if(locationManager == null){
            locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        }
        isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return isEnabled;
    }

    private void insertData(){

        Map<String,Object> map=new HashMap<>();
        map.put("Amount",amount.getEditableText().toString());
        map.put("Description",description.getEditableText().toString());
        map.put("Location",Location1.getEditableText().toString());
        map.put("Receipt",receipt.toString());
        map.put("Priority", priority.toString());
        map.put("Type",type.toString());
        map.put("Date",view_calendar.toString());
        map.put("Recurring_Status",recurring_status.toString());
        FirebaseDatabase.getInstance().getReference().child("debit_details").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(add_debit.this, R.string.data_add_message, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(add_debit.this, R.string.error_message, Toast.LENGTH_SHORT).show();
                    }
                });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),debit_showlist.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();
        receipt.setImageURI(uri);

    }

}