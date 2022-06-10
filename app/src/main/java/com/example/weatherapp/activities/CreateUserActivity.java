package com.example.weatherapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weatherapp.Globals;
import com.example.weatherapp.R;
import com.example.weatherapp.services.AuthService;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;

public class CreateUserActivity extends AppCompatActivity {
    Button buttonLogInBack;
    Button buttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        Button buttonCreateUserBack = findViewById(R.id.buttonCreateUserBack);
        EditText edit_text_createUser_email = findViewById(R.id.EditTextEmailCREATE_USER);
        EditText edit_text_createUser_password = findViewById(R.id.EditTextPasswordCREATE_USER);
        Button buttonRegister = findViewById(R.id.buttonCreateUserCREATE_USER);

        buttonCreateUserBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_register = edit_text_createUser_email.getText().toString();
                String password_register = edit_text_createUser_password.getText().toString();
                if (email_register.isEmpty()) {
                    showMassage("Email is empty");
                    return;
                }
                if (!email_register.contains("@") || email_register.length() < 3) {
                    showMassage("Email must be correct");
                    return;
                }
                if (password_register.isEmpty()) {
                    showMassage("Password is empty");
                    return;
                }
                if (password_register.length() < 6) {
                    showMassage("Password must be correct");
                    return;
                }


                AuthService.createUser(email_register, password_register)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                 Globals isRegistered = (Globals) getApplicationContext();
                                 isRegistered.setISREGISTERED(true);
                                startActivity(new Intent(getBaseContext(), ChoosingFigureActivityUnlocked.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        showMassage("Can't create user");
                    }
                });
            }
        });

    }


    void showMassage(String massage) {
        Toast.makeText(getBaseContext(), massage, Toast.LENGTH_SHORT).show();
    }
}
