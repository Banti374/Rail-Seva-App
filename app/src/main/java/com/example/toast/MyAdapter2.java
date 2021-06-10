package com.example.toast;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolader> {

    ArrayList<model2> mList2;

    Context context2;

    public MyAdapter2(Context context2, ArrayList<model2> mList2){

        this.mList2 = mList2;
        this.context2 = context2;
    }

    @NonNull
    @Override
    public MyViewHolader onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context2).inflate(R.layout.item2, parent, false);
        return new MyViewHolader(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolader holder, int position) {

        model2 model2 = mList2.get(position);
        holder.train_Name.setText(model2.getTrain_Name());
        holder.ticket_No.setText(model2.getTicket_No());
        holder.train_Station.setText(model2.getTrain_Station());
        holder.ticket_name.setText(model2.getTicket_name());
        holder.train_Time.setText(model2.getTrain_Time());
        holder.train_day.setText(model2.getTrain_day());

    }
    @Override
    public int getItemCount() {
        return mList2.size();
    }


    public static class MyViewHolader extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView train_Name,train_Station, ticket_No, ticket_name, train_Time, train_day;

        public  MyViewHolader(@NonNull View itemView) {
            super(itemView);

            train_Name = itemView.findViewById(R.id.trainnameblnk);
            train_Station = itemView.findViewById(R.id.ticketnameblnk);
            ticket_No = itemView.findViewById(R.id.ticketnoblnk);
            ticket_name = itemView.findViewById(R.id.ticketname2);
            train_day = itemView.findViewById(R.id.traindayblnk);
            train_Time = itemView.findViewById(R.id.traintimeblnk);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
