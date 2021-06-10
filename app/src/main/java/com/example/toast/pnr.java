package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class pnr extends AppCompatActivity {
    ImageView back;
    private EditText pnrview;
    Button searchpnr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnr);

        back= (ImageView) findViewById(R.id.imageViewback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(pnr.this,dashbrd.class);
                startActivity(intent);

            }
        });
        pnrview = findViewById(R.id.textViewpnr);
        searchpnr = (Button) findViewById(R.id.buttonpnrsearch);
        searchpnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pnrdata();
            }
        });

    }

    private void pnrdata() {
        String pnr = pnrview.getText().toString();
        Intent intent = new Intent(pnr.this, pnrfinal.class);
        intent.putExtra("keypnr", pnr);
        startActivity(intent);

    }
}