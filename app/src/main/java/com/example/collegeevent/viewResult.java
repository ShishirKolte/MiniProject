package com.example.collegeevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewResult extends AppCompatActivity {

    private DatabaseReference mDataBase;
    public static ArrayList<eventDetailsGetter> eventList;
    int position;
    TextView winner;
    TextView fRunnerUp;
    TextView sRunnerUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);

        mDataBase = FirebaseDatabase.getInstance().getReference().child("results");
        eventList = (ArrayList<eventDetailsGetter>) getIntent().getSerializableExtra("eventList");
        position = getIntent().getExtras().getInt("position");
        winner = findViewById(R.id.tWinnerEmpty);
        fRunnerUp = findViewById(R.id.tFirstRunnerUpDisplay);
        sRunnerUp = findViewById(R.id.tSecondRunnerUpEmpty);

       mDataBase.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               for (DataSnapshot data : dataSnapshot.getChildren()) {

                   if(eventList.get(position).getEventName().equals(String.valueOf(data.child("eventName").getValue())))
                   {
                       String winnerName = String.valueOf(data.child("winnerName").getValue());
                       String fName = String.valueOf(data.child("fRunnerUpName").getValue());
                       String sName = String.valueOf(data.child("sRunnerUpName").getValue());

                       winner.setText(winnerName);
                       fRunnerUp.setText(fName);
                       sRunnerUp.setText(sName);
                   }


               }

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {
               Toast.makeText(viewResult.this, "Oops... Something went wrong." + databaseError.getMessage(), Toast.LENGTH_LONG).show();
           }
       });



    }


}
