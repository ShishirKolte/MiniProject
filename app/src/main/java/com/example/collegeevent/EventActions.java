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
    private ArrayList<eventDetailsGetter> eventList = new ArrayList<eventDetailsGetter>() ;
    private int position;
    private TextView eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_actions);
        button = findViewById(R.id.bRegisterLink);
        eventName = findViewById(R.id.tEventName);

        if(getIntent().hasExtra("eventList"))
        {
            eventList = (ArrayList<eventDetailsGetter>) getIntent().getSerializableExtra("eventList");
            position = getIntent().getExtras().getInt("position");
            eventName.setText("Event : " + eventList.get(position).getEventName().toUpperCase());
        }
        else
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActions.this, registerStudent.class);
                startActivity(intent);
            }
        });

    }

}
