package com.example.toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class ticket extends AppCompatActivity {
    TextView textViewfromfinal,textViewtrainname,textViewday,textViewtime,textViewtime2, Ticket_No, ticket_name, price;
    private Button finalbutton;
    private FirebaseUser user;
    private String userID;
    DatabaseReference ticketdbref;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ticket);
        final Random myRandom = new Random();
        ticket_name = findViewById(R.id.fnameblnk);
        textViewtrainname= (TextView)findViewById(R.id.ftrainnameblnk);
        textViewfromfinal= (TextView)findViewById(R.id.fstationfromblnk);
        textViewday= (TextView)findViewById(R.id.dayblnk);
        textViewtime= (TextView)findViewById(R.id.ftimeblnk);
        price= (TextView)findViewById(R.id.fpriceblnk);
        textViewtime2= (TextView)findViewById(R.id.ftime2blnk);
        Ticket_No = (TextView)findViewById(R.id.textViewrandomno);
        finalbutton=(Button)findViewById(R.id.buttonbooking);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("user");
        userID = user.getUid();

        ticketdbref = FirebaseDatabase.getInstance().getReference().child("ticketdb");

        finalbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ticket_No.setText(String.valueOf(myRandom.nextInt(100000)));
                //database store part
                insertdata();

            }

        });

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user userProfile = snapshot.getValue(user.class);

                if(userProfile != null){
                    String name = userProfile.Name;

                    ticket_name.setText(name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ticket.this, "Something Wrong happen!", Toast.LENGTH_LONG).show();
            }

        });


        String trainname = getIntent().getStringExtra("keytrainname");
        textViewtrainname.setText(trainname);

        String stationfromfinal = getIntent().getStringExtra("keystation");
        textViewfromfinal.setText(stationfromfinal);

        String trainday = getIntent().getStringExtra("keytrainday");
        textViewday.setText(trainday);

        String traintime = getIntent().getStringExtra("keytraintime");
        textViewtime.setText(traintime);

        String traintime2 = getIntent().getStringExtra("keytraintime2");
        textViewtime2.setText(traintime2);

        String priceT = getIntent().getStringExtra("ticketprice");
        price.setText(priceT);


    }

    private void insertdata() {

        String tnamedb = ticket_name.getText().toString();
        String trainnamedb = textViewtrainname.getText().toString();
        String trainstationfromdb = textViewfromfinal.getText().toString();
        String refticketno = Ticket_No.getText().toString();


        String traintimedb  = textViewtime.getText().toString();
        String traindaydb =textViewday.getText().toString();

        String pricedb =price.getText().toString();


        ticketdb ticketdb = new ticketdb( tnamedb,trainnamedb,trainstationfromdb,traintimedb,traindaydb, refticketno, pricedb);
        ticketdbref.push().setValue(ticketdb);

        Intent intent=new Intent(ticket.this,dashbrd.class);
        startActivity(intent);
    }
}