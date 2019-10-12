package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.auth.*;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register =  findViewById(R.id.tSignUpLink);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityRegister();
            }
        });




        login =   findViewById(R.id.bLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                openEventView();
            }
        });




    }


    public void openEventView()
    {
        Intent intent;
        intent = new Intent(this, eventView.class);
        startActivity(intent);
    }



    public void openActivityRegister()
    {
        Intent intent;
        intent = new Intent(MainActivity.this, registerActivity.class);
        startActivity(intent);
    }

}
