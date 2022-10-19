package com.example.project_impl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.reactivex.rxjava3.annotations.NonNull;

public class RegistrationActivity extends AppCompatActivity {
    EditText First,Last, Email,Password;
    Button Register;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    TextView Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();
        First=(EditText) findViewById(R.id.editTextTextPersonName);
        Last= (EditText) findViewById(R.id.editTextTextPersonName2);
        Email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Register =(Button) findViewById(R.id.regis);

        Password =(EditText)  findViewById(R.id.editTextTextPassword);
        progressDialog = new ProgressDialog(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();

            }
        });

    }

    private void registerNewUser()
    {


        // Take the value of two edit texts in Strings
        String email, password, first,last;
        first = First.getText().toString();
        last = Last.getText().toString();
        email = Email.getText().toString();
        password = Password.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(first)) {
            Toast.makeText(getApplicationContext(),
                    R.string.First_name,
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(last)) {
            Toast.makeText(getApplicationContext(),
                    R.string.Last_name,
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    R.string.Email_message,
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    R.string.Password_message,
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        // create new user or register new user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    R.string.Registeration_success,
                                    Toast.LENGTH_LONG)
                                    .show();


                            // if the user created intent to login activity
                            Intent intent
                                    = new Intent(RegistrationActivity.this,
                                    home.class);
                            startActivity(intent);
                        }
                        else {

                            // Registration failed
                            Toast.makeText(
                                    getApplicationContext(),
                                    R.string.Registration_unsuccess
                                            + R.string.Try_again_Message,
                                    Toast.LENGTH_LONG)
                                    .show();


                        }
                        progressDialog.dismiss();
                    }
                });
    }
}