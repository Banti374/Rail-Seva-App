package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class location extends AppCompatActivity {
    EditText src,dest;
    Button b1;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        src = findViewById(R.id.src);
        dest = findViewById(R.id.dest);
        b1 = findViewById(R.id.b1);

        back= (ImageView) findViewById(R.id.imageViewbackL);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(location.this,dashbrd.class);
                startActivity(intent);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sSource = src.getText().toString();
                String sDestination = dest.getText().toString();
                if (sSource.equals("") && sDestination.equals("")){
                    Toast.makeText(getApplicationContext()
                            ,"Enter both location",Toast.LENGTH_SHORT).show();
                }
                else {
                    DisplayTrack(sSource,sDestination);
                }
            }
        });
    }
    private void DisplayTrack(String sSource,String sDestination){
        try {
            Uri uri = Uri.parse("https://www.google.com/maps/dir/" + sSource + "/" + sDestination);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}