package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class resultView extends AppCompatActivity {

    private Button button;
    EditText winnerName;
    EditText fRunnerUpName;
    EditText sRunnerUpName;
    private ArrayList<eventDetailsGetter> eventList = new ArrayList<eventDetailsGetter>() ;
    private int position;

    FirebaseDatabase DataBase = FirebaseDatabase.getInstance();
    DatabaseReference mEvents = DataBase.getReference("results");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_view);

        button = findViewById(R.id.bDone);
        winnerName = findViewById(R.id.tEnterWinner);
        fRunnerUpName = findViewById(R.id.tEnterFirstRunnerUp);
        sRunnerUpName = findViewById(R.id.tEnterSecondRunnerUp);

        eventList = (ArrayList<eventDetailsGetter>) getIntent().getSerializableExtra("eventList");
        position = getIntent().getExtras().getInt("position");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference childRef = mEvents.push();
                childRef.child("winnerName").setValue(winnerName.getText().toString());
                childRef.child("fRunnerUpName").setValue(fRunnerUpName.getText().toString());
                childRef.child("sRunnerUpName").setValue(sRunnerUpName.getText().toString());
                childRef.child("eventName").setValue(eventList.get(position).getEventName());

                Intent intent = new Intent(resultView.this, EventActions.class);
                startActivity(intent);

            }
        });
    }
}
