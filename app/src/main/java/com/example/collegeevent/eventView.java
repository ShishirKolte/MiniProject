package com.example.collegeevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class eventView extends AppCompatActivity {


    private Button button;
    private Button signout;
    private RecyclerView recyclerView;
    private eventAdapter adapter;
    public static ArrayList<eventDetailsGetter> eventList;
    private DatabaseReference mDataBase;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);


        mDataBase = FirebaseDatabase.getInstance().getReference().child("events");


        recyclerView = findViewById(R.id.recycler1);


        button = findViewById(R.id.bCreateNewEvent);



        mAuth = FirebaseAuth.getInstance();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        eventList = new ArrayList<eventDetailsGetter>();

        mDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    eventDetailsGetter eventDetails = dataSnapshot1.getValue(eventDetailsGetter.class);
                    eventList.add(eventDetails);
                }
                adapter = new eventAdapter(eventView.this, eventList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(eventView.this, "Oops... Something went wrong." + databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(eventView.this, create_event.class);
                startActivity(intent);
            }
        });

//        signout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                mAuth.signOut();
//                Intent intent;
//                intent = new Intent(eventView.this, MainActivity.class);
//                startActivity(intent);
//
//            }
//        });

    }

}
