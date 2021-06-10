package com.example.toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class profile extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private DatabaseReference cooolieref;
    private String userID;

    private ImageView back;
    private Button logout, ticketviewx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        logout = (Button) findViewById(R.id.signout);


        final TextView greetingtextView = (TextView) findViewById(R.id.greeting);
        final TextView nameTextView = (TextView) findViewById(R.id.nameblnk);
        final TextView phoneTextView = (TextView) findViewById(R.id.phoneblnk);
        final TextView emailTextView = (TextView) findViewById(R.id.emailblnk);

        back= (ImageView) findViewById(R.id.imageViewbackpr);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profile.this,dashbrd.class);
                startActivity(intent);

            }
        });

        ticketviewx=(Button) findViewById(R.id.ticketbtn);
        ticketviewx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profile.this,Ticketview.class);

                String nameTK = nameTextView.getText().toString();
                intent.putExtra("keynameTK", nameTK);
                startActivity(intent);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(profile.this,MainActivity.class));

            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("user");
        userID = user.getUid();










        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user userProfile = snapshot.getValue(user.class);

                if(userProfile != null){
                    String name = userProfile.Name;
                    String phonenuber = userProfile.phonenumber;
                    String email = userProfile.email;

                    greetingtextView.setText("Welcome, " + name + "!" );
                    nameTextView.setText(name);
                    phoneTextView.setText(phonenuber);
                    emailTextView.setText(email);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(profile.this, "Something Wrong happen!", Toast.LENGTH_LONG).show();

            }
        });

    }
}