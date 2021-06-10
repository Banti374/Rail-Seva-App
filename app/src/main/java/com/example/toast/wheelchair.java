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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Calendar;

public class wheelchair extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private TextView dateText;

    private EditText editTextName, editTextphone, editTextcoachno, editTexttrainname;
    private ProgressBar progressBar;
    private Button wheelchairbtn;
    private TextView textViewdate;
    DatabaseReference wheelchairdbref;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheelchair);

        editTextName = (EditText) findViewById(R.id.wheelname);
        editTextphone = (EditText) findViewById(R.id.wheelphone);
        editTextcoachno = (EditText) findViewById(R.id.wheelcoach);
        editTexttrainname = (EditText)findViewById(R.id.wheeltrainname);
        textViewdate = (TextView)findViewById(R.id.date_text);


        back= (ImageView) findViewById(R.id.imageViewback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(wheelchair.this,dashbrd.class);
                startActivity(intent);

            }
        });

        progressBar = (ProgressBar) findViewById(R.id.progressBarwheel);

        wheelchairdbref = FirebaseDatabase.getInstance().getReference().child("wheelchairdb");


        dateText = findViewById(R.id.date_text);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDailog();
            }
        });
        wheelchairbtn = findViewById(R.id.buttonwheel);
        wheelchairbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdata();
            }
        });
    }

    private void insertdata() {
        String wname = editTextName.getText().toString();
        String wphone = editTextphone.getText().toString();
        String wcoach = editTextcoachno.getText().toString();
        String wtrainNo = editTexttrainname.getText().toString();
        String date = textViewdate.getText().toString();

        wheelchairdb wheelchairdb = new wheelchairdb(wname,wphone,wcoach,wtrainNo,date);
        wheelchairdbref.push().setValue(wheelchairdb);
        Toast.makeText(wheelchair.this,"Booking Succesfull!",Toast.LENGTH_LONG).show();
    }



    private void showDatePickerDailog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date =  month + "/" + dayOfMonth + "/" + year ;
        dateText.setText(date);
    }
}