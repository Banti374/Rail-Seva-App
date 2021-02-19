package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText NAME;
    EditText PASSWORD;
    Button SUBMIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NAME = (EditText) findViewById(R.id.editTextName);
        PASSWORD = (EditText) findViewById(R.id.editTextPassword);
        SUBMIT = (Button) findViewById(R.id.button);

        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!NAME.getText().toString().isEmpty() && !PASSWORD.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "WELCOME TO MY APP", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "EMPTY FIELDS PLEASE FIELD THAT", Toast.LENGTH_SHORT).show();
                }
                Intent i = new Intent(MainActivity.this, dashbrd.class);
                startActivity(i);
            }
        });

    }
}