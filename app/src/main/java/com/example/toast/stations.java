package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class stations extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);

        back= (ImageView) findViewById(R.id.imageViewback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(stations.this,dashbrd.class);
                startActivity(intent);

            }
        });

        final Spinner s = (Spinner)findViewById(R.id.spinner);
        final ImageView i=(ImageView)findViewById(R.id.iv);
        String[] st=getResources().getStringArray(R.array.Station);
        ArrayAdapter<String> da=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,st);
        s.setAdapter(da);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String p=s.getSelectedItem().toString();
                if(p.equals("Surat"))
                {
                    i.setImageResource(R.drawable.surat);
                }
                else if(p.equals("Vadodara"))
                {
                    i.setImageResource(R.drawable.brc);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}