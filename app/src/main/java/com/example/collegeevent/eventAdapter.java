package com.example.collegeevent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class eventAdapter extends  RecyclerView.Adapter<eventAdapter.eventViewHolder>{


    private Context mCtx;

    private ArrayList<eventDetailsGetter> eventList;

    public eventAdapter(Context mCtx, ArrayList<eventDetailsGetter> eventList) {
        this.mCtx = mCtx;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public eventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.show_event_item, parent,false);
        return new eventViewHolder(view);

    }




    @Override
    public void onBindViewHolder(@NonNull eventViewHolder holder, int position) {


        holder.textViewTitle.setText(eventList.get(position).getEventName());
        holder.textViewDesc.setText(eventList.get(position).getEventDesc());



    }




    @Override
    public int getItemCount() {
        return eventList.size();
    }




    class eventViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewTitle, textViewDesc;



        public eventViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);

        }
    }

}
