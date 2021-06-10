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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Random;

public class coolie extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private TextView dateText2;
    private EditText editTxtName, editTxtphone,editTxtemail ,editTxtcoachno, editticketnumber;
    TextView coolieNo;
    DatabaseReference coolieref;
    private Button Buttoncoolie;
    private TextView textViewdate;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coolie);
        final Random myRandom = new Random();


        editTxtName = (EditText) findViewById(R.id.textname);
        editTxtphone = (EditText) findViewById(R.id.textphoneno);
        editTxtemail = (EditText) findViewById(R.id.textemail);
        editTxtcoachno = (EditText) findViewById(R.id.inputcoach);
        editticketnumber = (EditText) findViewById(R.id.textticket);
        coolieNo = (TextView)findViewById(R.id.textViewrandomno2);
        textViewdate = (TextView)findViewById(R.id.date_text2);

        back= (ImageView) findViewById(R.id.imageViewback2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(coolie.this,dashbrd.class);
                startActivity(intent);

            }
        });


        coolieref = FirebaseDatabase.getInstance().getReference().child("Cooliedb");

        dateText2 = findViewById(R.id.date_text2);

        findViewById(R.id.show_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDailog();
            }
        });
        Buttoncoolie = findViewById(R.id.buttoncoolie);
        Buttoncoolie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coolieNo.setText(String.valueOf(myRandom.nextInt(10000)));
                insertdata();
            }
        });
    }

    private void insertdata() {
        String cname = editTxtName.getText().toString();
        String cphone = editTxtphone.getText().toString();
        String cemail = editTxtemail.getText().toString();
        String ccoach = editTxtcoachno.getText().toString();
        String refcoolieno = coolieNo.getText().toString();
        String cticketNo = editticketnumber.getText().toString();
        String cdate = textViewdate.getText().toString();

        cooliedb cooliedb = new cooliedb(cname, cphone, cemail, ccoach,cticketNo, cdate, refcoolieno);
        coolieref.push().setValue(cooliedb);
        Toast.makeText(coolie.this,"Booking Succesfull!",Toast.LENGTH_LONG).show();


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
        dateText2.setText(date);
    }
}