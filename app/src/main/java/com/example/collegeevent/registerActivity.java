package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {


    private String getUserName;
    private String getPassword;
    private Button button;
    private EditText userName;
    private EditText password;
    private EditText confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = findViewById(R.id.bSignUp);
        userName = findViewById(R.id.tUserName);
        password = findViewById(R.id.tPassword);
        confirmPassword = findViewById(R.id.tConfirmPassword);

    }

    public void click(View view){

        try
        {
            getUserName = userName.getText().toString();
            getPassword = password.getText().toString();
            if(getPassword.equals(confirmPassword.getText().toString()))
            {
                Intent intent = new Intent(registerActivity.this, MainActivity.class );
                startActivity(intent);
                throw new Exception("Password Match");

            }
            else
            {
                throw new Exception("Passwords not matching");
            }
        }
        catch (Exception s)
        {
            Toast.makeText(registerActivity.this, s.toString(), Toast.LENGTH_LONG).show();

        }

    }
}
