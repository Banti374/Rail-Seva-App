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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class pnrfinal extends AppCompatActivity {
    TextView textViewpnr;
    ImageView back;
    MyAdapter2 myAdapter2;
    ArrayList<model2> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnrfinal);

        textViewpnr = findViewById(R.id.textpnr);

        String pnrview = getIntent().getStringExtra("keypnr");
        textViewpnr.setText(pnrview);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recyclebiew2);

        back= (ImageView) findViewById(R.id.imageViewback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(pnrfinal.this,pnr.class);
                startActivity(intent);

            }
        });


        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));


        list2 = new ArrayList<>();
        myAdapter2 = new MyAdapter2(this,list2);
        recyclerView2.setAdapter(myAdapter2);


        Query query = FirebaseDatabase.getInstance().getReference("ticketdb").orderByChild("ticket_No").equalTo(pnrview);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    model2 model2 = dataSnapshot.getValue(model2.class);
                    list2.add(model2);

                }
                myAdapter2.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}