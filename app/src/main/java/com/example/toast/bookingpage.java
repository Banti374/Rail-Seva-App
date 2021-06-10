package com.example.toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class bookingpage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button bookbutton;
    TextView textViewfrom, textViewto;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<model> list;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingpage);

        textViewfrom= (TextView)findViewById(R.id.textviewfrom);
        textViewto= (TextView)findViewById(R.id.textviewto);

        String stationfrom = getIntent().getStringExtra("keystationfrom");
        String stationto = getIntent().getStringExtra("keystationto");
        textViewfrom.setText(stationfrom);
        textViewto.setText(stationto);


        recyclerView = (RecyclerView) findViewById(R.id.recyclebiew);

        back= (ImageView) findViewById(R.id.imageViewback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bookingpage.this,booking.class);
                startActivity(intent);

            }
        });


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);


        Query query = FirebaseDatabase.getInstance().getReference("traindb2").orderByChild("stations").equalTo(stationfrom+"-"+stationto);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    model model = dataSnapshot.getValue(model.class);
                    list.add(model);

                }
                myAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}