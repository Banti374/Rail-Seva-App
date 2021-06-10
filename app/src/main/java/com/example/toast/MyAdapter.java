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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolader>{

    ArrayList<model> mList;

    Context context;

    public MyAdapter(Context context, ArrayList<model> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolader onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        return new MyViewHolader(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolader holder, int position) {

        model model = mList.get(position);
        holder.train_Name.setText(model.getTrain_Name());
        //holder.stationdesti.setText(model.getstationdesti());
        holder.stations.setText(model.getStations());
        holder.time_Arrive.setText(model.getTime_Arrive());
        holder.day.setText(model.getday());
        holder.train_No.setText(model.getTrain_No());
        holder.departure.setText(model.getDeparture());
        holder.ticket_Price.setText(model.getTicket_Price());

        }
    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolader extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView train_Name,stationdesti, day,train_No, stations, time_Arrive, departure, ticket_Price;

        public  MyViewHolader(@NonNull View itemView) {
            super(itemView);

            train_Name = itemView.findViewById(R.id.trainnameblnk);
            stations = itemView.findViewById(R.id.stationblnk);
            //stationdesti = itemView.findViewById(R.id.station2blnk);
            time_Arrive = itemView.findViewById(R.id.timeblnk);
            day = itemView.findViewById(R.id.dayblnk);
            train_No = itemView.findViewById(R.id.trainnoblnk);
            departure = itemView.findViewById(R.id.time2blnk);
            ticket_Price = itemView.findViewById(R.id.trainpriceblnk);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            String station = stations.getText().toString();
            String tname = train_Name.getText().toString();
            String tday = day.getText().toString();
            String ttime = time_Arrive.getText().toString();
            String ttime2 = departure.getText().toString();
            String tprice = ticket_Price.getText().toString();


            Toast.makeText(context,"One step to book",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context,ticket.class);
            intent.putExtra("keystation", station);
            intent.putExtra("keytrainname", tname);
            intent.putExtra("keytrainday",tday);
            intent.putExtra("keytraintime", ttime);
            intent.putExtra("keytraintime2", ttime2);
            intent.putExtra("ticketprice",tprice);
            context.startActivity(intent);
        }
    }
}
