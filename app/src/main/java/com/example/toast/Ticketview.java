package com.example.toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Ticketview extends AppCompatActivity {


    MyAdapterTK myAdapter3;
    ArrayList<modelTK> list3;
    TextView namebox;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketview);

        back= (ImageView) findViewById(R.id.imageViewbackTK);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Ticketview.this,profile.class);
                startActivity(intent);

            }
        });

        namebox = (TextView) findViewById(R.id.namebox);

        String name = getIntent().getStringExtra("keynameTK");
        namebox.setText(name);


        RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.recyclebiew3);

        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));

        list3 = new ArrayList<modelTK>();
        myAdapter3 = new MyAdapterTK(this,list3);
        recyclerView3.setAdapter(myAdapter3);

        Query query2 = FirebaseDatabase.getInstance().getReference("ticketdb").orderByChild("ticket_name").equalTo(name);
        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    modelTK modelTK = dataSnapshot.getValue(modelTK.class);
                    list3.add(modelTK);

                }
                myAdapter3.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}