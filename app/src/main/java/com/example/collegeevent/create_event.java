package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class create_event extends AppCompatActivity {


    private Button button;
    EditText eventName;
    EditText eventDesc;


    int eventId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        button = findViewById(R.id.bCreateEvent);
        eventName = findViewById(R.id.tEventNameMain);
        eventDesc = findViewById(R.id.tEventDetails);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eventView.eventList.add(new eventDetailsGetter(
                        eventId++,
                        eventName.getText().toString(),
                        eventDesc.getText().toString()
                ));



                Intent intent;
                intent = new Intent(create_event.this, eventView.class);
                startActivity(intent);
            }
        });



    }
}
