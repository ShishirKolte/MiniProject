package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.UncheckedIOException;
import java.util.ArrayList;

public class registerStudent extends AppCompatActivity {


    FirebaseDatabase DataBase = FirebaseDatabase.getInstance();
    DatabaseReference mParticipants = DataBase.getReference("participants");
    private ArrayList<eventDetailsGetter> eventList = new ArrayList<eventDetailsGetter>();
    Button button;
    EditText participantName;
    EditText participantCollege;
    int position;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);



        button = findViewById(R.id.bRegisterLink);
        participantName = findViewById(R.id.tNameRegister);
        participantCollege = findViewById(R.id.tCollegeRegister);

        if(getIntent().hasExtra("eventList"))
        {

            eventList = (ArrayList<eventDetailsGetter>) getIntent().getSerializableExtra("eventList");
            position = getIntent().getExtras().getInt("position");

        }
        else
        {
            Toast.makeText(this, "Refreshing Data", Toast.LENGTH_SHORT).show();
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference childRef = mParticipants.push();
                childRef.child("participantEvent").setValue(eventList.get(position).getEventName());
                childRef.child("participantName").setValue(participantName.getText().toString());
                childRef.child("participantCollege").setValue(participantCollege.getText().toString());
                Toast.makeText(registerStudent.this, "Entry Added.", Toast.LENGTH_SHORT).show();
                onRegisterStudentClick();
            }
        });


    }


    public void onRegisterStudentClick()
    {
        Intent intent = new Intent(registerStudent.this, EventActions.class);
        startActivity(intent);
    }




}
