package com.example.collegeevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showParticipantList extends AppCompatActivity {


    private RecyclerView recyclerView;
    private participantAdapter adapter1;
    public static ArrayList<participantDetailsGetter> participantList;
    public static ArrayList<eventDetailsGetter> eventList;
    int position;
    private DatabaseReference mDataBase;
    private FirebaseUser mUser;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_participant_list);

        mDataBase = FirebaseDatabase.getInstance().getReference().child("participants");


        recyclerView = findViewById(R.id.participantRecycler);


        if(getIntent().hasExtra("eventList"))
        {
            eventList = (ArrayList<eventDetailsGetter>) getIntent().getSerializableExtra("eventList");
            position = getIntent().getExtras().getInt("position");

        }
        else
        {
            Toast.makeText(this, "Refereshing Data", Toast.LENGTH_SHORT).show();
        }


        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        participantList = new ArrayList<participantDetailsGetter>();

        mDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    participantDetailsGetter participantDetails = dataSnapshot1.getValue(participantDetailsGetter.class);
                    if(participantDetails.getParticipantEvent().equals(eventList.get(position).getEventName()))
                    {
                        participantList.add(participantDetails);
                    }


                }
                adapter1 = new participantAdapter(showParticipantList.this, participantList);
                recyclerView.setAdapter(adapter1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(showParticipantList.this, "Oops... Something went wrong." + databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });









    }
}
