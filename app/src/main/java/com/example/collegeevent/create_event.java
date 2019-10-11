package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class create_event extends AppCompatActivity {


    private Button button;
    EditText eventName;
    EditText eventDesc;
    FirebaseDatabase DataBase = FirebaseDatabase.getInstance();
    DatabaseReference mDataBase = DataBase.getReference("events");
    int inc = 0;


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

                DatabaseReference childref = mDataBase.push();
                childref.child("eventName").setValue(eventName.getText().toString());
                childref.child("eventDesc").setValue(eventDesc.getText().toString());


                Intent intent;
                intent = new Intent(create_event.this, eventView.class);
                startActivity(intent);
            }
        });



    }
}
