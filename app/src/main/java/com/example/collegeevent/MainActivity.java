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

public class MainActivity extends AppCompatActivity {

    private Button login;
    private TextView register;
    EditText eUserEmail;
    EditText pUserPassword;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUserEmail = findViewById(R.id.eUserEmail);
        pUserPassword = findViewById(R.id.pUserPassword);

        onStart();

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
            public void onClick(View view)
            {
                //Login existing users
                mAuth.signInWithEmailAndPassword(eUserEmail.getText().toString(), pUserPassword.getText().toString()).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            openEventView();
                        }
                        else
                            {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                    }
                });
            }
        });

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
    }




    public void openEventView()
    {
        Intent intent;
        intent = new Intent(this, eventView.class);
        startActivity(intent);
    }

    public void onStart()
    {
        super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        if(mAuth.getCurrentUser()!= null)
        {
            //Move to next page.
            openEventView();
        }

    }

    public void openActivityRegister()
    {
        Intent intent;
        intent = new Intent(MainActivity.this, registerActivity.class);
        startActivity(intent);
    }

}
