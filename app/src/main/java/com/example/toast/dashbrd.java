package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class dashbrd extends AppCompatActivity {


    private ImageView profile;

    TextView textViewone,textViewtwo,textViewthree,textViewfour,textViewfive, textViewsix, textViewseven,textViewfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbrd);

        profile = (ImageView)findViewById(R.id.imageprofile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dashbrd.this,profile.class));
            }
        });




        textViewone=(TextView)findViewById(R.id.booking);

        textViewone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dashbrd.this,booking.class);
                startActivity(intent);

                Toast.makeText(dashbrd.this, "You clicked on Booking", Toast.LENGTH_LONG).show();

            }

        });
        textViewtwo=(TextView)findViewById(R.id.stationc);

        textViewtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dashbrd.this,stations.class);
                startActivity(intent);

                Toast.makeText(dashbrd.this, "You clicked on Station", Toast.LENGTH_LONG).show();

            }

        });
        textViewthree=(TextView)findViewById(R.id.pnrc);

        textViewthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashbrd.this, pnr.class);
                startActivity(intent);

                Toast.makeText(dashbrd.this, "You clicked on PNR ENQUIRY", Toast.LENGTH_LONG).show();

            }

        });

        textViewfour=(TextView)findViewById(R.id.compaintc);

        textViewfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashbrd.this, complaint.class);
                startActivity(intent);

                Toast.makeText(dashbrd.this, "You clicked on Complaint", Toast.LENGTH_LONG).show();

            }

        });
        textViewfive=(TextView)findViewById(R.id.aboutusc);

        textViewfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashbrd.this, aboutus.class);
                startActivity(intent);

                Toast.makeText(dashbrd.this, "You clicked on AboutUs", Toast.LENGTH_LONG).show();

            }

        });
        textViewsix=(TextView)findViewById(R.id.cooliec);

        textViewsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashbrd.this, coolie.class);
                startActivity(intent);

                Toast.makeText(dashbrd.this, "You clicked on Coolie service", Toast.LENGTH_LONG).show();

            }

        });

        textViewseven=(TextView)findViewById(R.id.wheelchairc);

        textViewseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashbrd.this, wheelchair.class);
                startActivity(intent);

                Toast.makeText(dashbrd.this, "You clicked on Wheel Chair service", Toast.LENGTH_LONG).show();

            }

        });

        textViewfinal=(TextView)findViewById(R.id.schedulec);

        textViewfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashbrd.this,location.class);
                startActivity(intent);

                Toast.makeText(dashbrd.this, "You clicked on Station map", Toast.LENGTH_LONG).show();

            }

        });

    }
}