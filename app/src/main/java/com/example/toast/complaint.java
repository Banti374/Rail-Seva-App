package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class complaint extends AppCompatActivity {

    private EditText textname, textemail, textcomplaint, textcity;
    private Button complaintbtn;
    DatabaseReference complaintdbref;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        textname = (EditText) findViewById(R.id.textcomplaintname);
        textemail = (EditText) findViewById(R.id.textcomplaintemail);
        textcomplaint = (EditText) findViewById(R.id.textcomplaintbox);
        textcity = (EditText) findViewById(R.id.textcomplaintcity);

        back= (ImageView) findViewById(R.id.imageViewback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(complaint.this,dashbrd.class);
                startActivity(intent);

            }
        });

        complaintdbref = FirebaseDatabase.getInstance().getReference().child("complaintdb");
        complaintbtn = (Button) findViewById(R.id.buttoncomplaint);
        complaintbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdata();
            }
        });
    }

    private void insertdata() {
        String cname = textname.getText().toString();
        String cemail = textemail.getText().toString();
        String ccomplaint = textcomplaint.getText().toString();
        String city = textcity.getText().toString();

        compalintdb compalintdb = new compalintdb(cname,cemail,ccomplaint,city);
        complaintdbref.push().setValue(compalintdb);
        Toast.makeText(complaint.this,"Submit Succesfull!",Toast.LENGTH_LONG).show();
    }
}