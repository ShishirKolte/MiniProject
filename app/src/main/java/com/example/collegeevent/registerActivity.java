package com.example.collegeevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class registerActivity extends AppCompatActivity {


    private String getUserName;
    private String getPassword;
    private Button button;
    private EditText userName;
    private EditText password;
    private EditText confirmPassword;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        button = findViewById(R.id.bSignUp);
        userName = findViewById(R.id.tUserName);
        password = findViewById(R.id.tPassword);
        confirmPassword = findViewById(R.id.tConfirmPassword);

    }

    public void click(View view){

        mAuth.createUserWithEmailAndPassword(userName.getText().toString(), password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            openEventView();
                        }
                        else
                            {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(registerActivity.this, "Signup failed.", Toast.LENGTH_SHORT).show();
                            }
                    }
                });


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

    public void openEventView()
    {
        Intent intent;
        intent = new Intent(this, eventView.class);
        startActivity(intent);
    }

}
