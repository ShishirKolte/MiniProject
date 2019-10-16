package com.example.collegeevent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class participantAdapter extends RecyclerView.Adapter<participantAdapter.participantViewHolder> {


    private Context pCtx;
    private ArrayList<participantDetailsGetter> participantList ;

    public participantAdapter(Context mCtx, ArrayList<participantDetailsGetter> participantList) {
        this.pCtx = mCtx;
        this.participantList = participantList;
    }

    @NonNull
    @Override
    public participantAdapter.participantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(pCtx);
        View view = inflater.inflate(R.layout.show_event_item, parent,false);
        return new participantAdapter.participantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull participantAdapter.participantViewHolder holder, final int position) {


        holder.textViewTitle.setText(participantList.get(position).getParticipantName());
        holder.textViewDesc.setText(participantList.get(position).getParticipantCollege());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(mCtx, EventActions.class);
//                intent.putExtra("eventList", eventList);
//                intent.putExtra("position", position);
//                mCtx.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return participantList.size();
    }

    class participantViewHolder extends RecyclerView.ViewHolder  {

        public TextView textViewTitle, textViewDesc;



        public participantViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);

        }



    }
}
