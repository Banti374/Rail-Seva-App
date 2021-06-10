package com.example.toast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterTK extends RecyclerView.Adapter<MyAdapter2.MyViewHolader> {

    ArrayList<modelTK> mList3;

    Context context3;

    public MyAdapterTK(Context context2, ArrayList<modelTK> mList3){

        this.mList3 = mList3;
        this.context3 = context2;
    }

    @NonNull
    @Override
    public MyAdapter2.MyViewHolader onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context3).inflate(R.layout.item2, parent, false);
        return new MyAdapter2.MyViewHolader(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolader holder, int position) {

        modelTK modelTK = mList3.get(position);
        holder.train_Name.setText(modelTK.getTrain_Name());
        holder.train_Station.setText(modelTK.getTrain_Station());
        holder.ticket_No.setText(modelTK.getTicket_No());
        holder.ticket_name.setText(modelTK.getTicket_name());
        holder.train_Time.setText(modelTK.getTrain_Time());
        holder.train_day.setText(modelTK.getTrain_day());


    }
    @Override
    public int getItemCount() {
        return mList3.size();
    }


    public static class MyViewHolader extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView train_Name,train_Station, ticket_No, ticket_name, train_Time, train_day;

        public  MyViewHolader(@NonNull View itemView) {
            super(itemView);

            train_Name = itemView.findViewById(R.id.trainnameblnk);
            train_Station = itemView.findViewById(R.id.stationblnk);
            ticket_No = itemView.findViewById(R.id.ticketnoblnk);
            ticket_name = itemView.findViewById(R.id.ticketname2);
            train_day = itemView.findViewById(R.id.traindayblnk);
            train_Time = itemView.findViewById(R.id.traintimeblnk);
            //time_Arrive = itemView.findViewById(R.id.timeblnk);
            //day = itemView.findViewById(R.id.dayblnk);
            //train_No = itemView.findViewById(R.id.trainnoblnk);
            //departure = itemView.findViewById(R.id.time2blnk);
            //ticket_Price = itemView.findViewById(R.id.trainpriceblnk);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}