package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventActions extends AppCompatActivity {

    Button button;
    Button showList;
    Button enterResult;
    Button viewResult;
    private ArrayList<eventDetailsGetter> eventList = new ArrayList<eventDetailsGetter>() ;
    private int position;
    private TextView eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_actions);
        button = findViewById(R.id.bRegisterLink);
        eventName = findViewById(R.id.tEventName);
        showList = findViewById(R.id.bViewListLink);
        enterResult = findViewById(R.id.bEditEvent);
        viewResult = findViewById(R.id.bViewResultLink);

        if(getIntent().hasExtra("eventList"))
        {
            eventList = (ArrayList<eventDetailsGetter>) getIntent().getSerializableExtra("eventList");
            position = getIntent().getExtras().getInt("position");
            eventName.setText("Event : " + eventList.get(position).getEventName().toUpperCase());
        }
        else
        {
            Toast.makeText(this, "Refereshing Data", Toast.LENGTH_SHORT).show();
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActions.this, registerStudent.class);
                intent.putExtra("position", position);
                intent.putExtra("eventList", eventList);
                startActivity(intent);
            }
        });

        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActions.this, showParticipantList.class);
                intent.putExtra("position", position);
                intent.putExtra("eventList", eventList);
                startActivity(intent);
            }
        });

        enterResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActions.this, resultView.class);
                intent.putExtra("position", position);
                intent.putExtra("eventList", eventList);
                startActivity(intent);

            }
        });

        viewResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActions.this, viewResult.class);
                intent.putExtra("position", position);
                intent.putExtra("eventList", eventList);
                startActivity(intent);


            }
        });

    }

}
