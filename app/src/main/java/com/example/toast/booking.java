package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class booking extends AppCompatActivity {

    private TextView dateText3;
    public EditText editTextstationfrom, editTextstationto;
    private Button searchbutton;
    private ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        editTextstationfrom = findViewById(R.id.stationfrom);
        editTextstationto = findViewById(R.id.stationto);
        back= (ImageView) findViewById(R.id.imageViewback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(booking.this,dashbrd.class);
                startActivity(intent);

            }
        });


        searchbutton = (Button) findViewById(R.id.searchbutton);

        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stationfrom = editTextstationfrom.getText().toString();
                String stationto = editTextstationto.getText().toString();

                Intent intent = new Intent(booking.this, bookingpage.class);
                intent.putExtra("keystationfrom", stationfrom);
                intent.putExtra("keystationto", stationto);
                startActivity(intent);


                //startActivity(new Intent(booking.this, bookingpage.class));

            }
        });

    }
}