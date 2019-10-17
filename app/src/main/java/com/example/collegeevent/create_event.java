package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class create_event extends AppCompatActivity {


    private Button button;
    EditText eventName;
    EditText eventDesc;
    EditText eventDate;
    EditText eventTime;
    EditText eventLevels;
    FirebaseDatabase DataBase = FirebaseDatabase.getInstance();
    DatabaseReference mEvents = DataBase.getReference("events");
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser mUser = mAuth.getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        button = findViewById(R.id.bCreateEvent);
        eventName = findViewById(R.id.tEventNameMain);
        eventDesc = findViewById(R.id.tEventDetails);
        eventDate = findViewById(R.id.tDate);
        eventTime = findViewById(R.id.tTime);
        eventLevels = findViewById(R.id.tLevels);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference childRef = mEvents.push();
                childRef.child("eventName").setValue(eventName.getText().toString());
                childRef.child("eventDesc").setValue(eventDesc.getText().toString());
                childRef.child("eventDate").setValue(eventDate.getText().toString());
                childRef.child("eventTime").setValue(eventTime.getText().toString());
                childRef.child("eventLevels").setValue(eventLevels.getText().toString());
                childRef.child("eventAdmin").setValue(mUser.getUid());


                Intent intent;
                intent = new Intent(create_event.this, eventView.class);
                startActivity(intent);
            }
        });



    }
}
