package com.example.toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class singup extends AppCompatActivity implements View.OnClickListener {


    private TextView banner, registerUser;
    private EditText editTextFullName, editTextsurnameusr, editTextemails, editTextpasswords, editTextcpassword, editTextphonenumber;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        mAuth = FirebaseAuth.getInstance();


        back= (ImageView) findViewById(R.id.imageViewback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(singup.this,MainActivity.class);
                startActivity(intent);

            }
        });



        banner = (TextView) findViewById(R.id.banners);
        banner.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.registerUsers);
        registerUser.setOnClickListener(this);

        editTextFullName = (EditText)findViewById(R.id.signupname);
        editTextsurnameusr = (EditText)findViewById(R.id.signupsurname);
        editTextphonenumber = (EditText)findViewById(R.id.signupphonenumber);


        editTextemails = (EditText)findViewById(R.id.signupemail);
        editTextpasswords = (EditText)findViewById(R.id.signuppass);
        editTextcpassword = (EditText)findViewById(R.id.signupconfirmpass);

        progressBar = (ProgressBar)findViewById(R.id.progressBar4);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banners:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.registerUsers:
                registerUser();
                break;
        }

    }
    private void registerUser() {
        String name = editTextFullName.getText().toString().trim();
        String surname = editTextsurnameusr.getText().toString().trim();
        String email = editTextemails.getText().toString().trim();
        String phone = editTextphonenumber.getText().toString().trim();
        String password = editTextpasswords.getText().toString().trim();
        String confirmpassword = editTextcpassword.getText().toString().trim();

        if(name.isEmpty()){
            editTextFullName.setError("Name is required!");
            editTextFullName.requestFocus();
            return;
        }

        if(surname.isEmpty()){
            editTextsurnameusr.setError("Surename is required!");
            editTextsurnameusr.requestFocus();
            return;
        }

        if(phone.isEmpty()){
            editTextphonenumber.setError("Surename is required!");
            editTextphonenumber.requestFocus();
            return;
        }

        if(phone.length()<8){
            editTextphonenumber.setError("Please Enter Valid Phonenumber");
            editTextphonenumber.requestFocus();
            return;
        }

        if (!Patterns.PHONE.matcher(phone).matches()){
            editTextphonenumber.setError("Please enter valid Phone Number.");
            editTextphonenumber.requestFocus();
            return;
        }


        if(email.isEmpty()){
            editTextemails.setError("Email is required!");
            editTextemails.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemails.setError("Please enter valid Email.");
            editTextemails.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextpasswords.setError("Password is required!");
            editTextpasswords.requestFocus();
            return;
        }

        if(password.length()<8){
            editTextpasswords.setError("Min password length should be 8 character!");
            editTextpasswords.requestFocus();
            return;
        }


        if(confirmpassword.isEmpty()){
            editTextcpassword.setError("Please Confirm your password!");
            editTextcpassword.requestFocus();
            return;

        }
        if(!(confirmpassword.matches(password))){
            editTextcpassword.setError("Passwrd Should be match");
            editTextcpassword.requestFocus();
            return;

        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            user user =new user(name, phone, email, password);

                            FirebaseDatabase.getInstance().getReference("user")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(singup.this,"User has been register successfully!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                        startActivity(new Intent(singup.this, MainActivity.class));

                                    }else {
                                        Toast.makeText(singup.this, "Failed to register! Try agian!", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }

                                }
                            });

                        }else {
                            Toast.makeText(singup.this, "Failed to register! Try agian!", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


    }
}