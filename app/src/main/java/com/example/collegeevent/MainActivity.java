package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button login = (Button) findViewById(R.id.bLogin);
    private TextView register = (TextView) findViewById(R.id.tRegisterRedirect);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityRegister();
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEventView();
            }
        });




    }


    public void openEventView()
    {

    }

    public void openActivityRegister()
    {
        Intent intent;
        intent = new Intent(this, registerActivity.class);
        startActivity(intent);
    }

}
