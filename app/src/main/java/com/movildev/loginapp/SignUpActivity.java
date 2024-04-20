package com.movildev.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    EditText username, email, phone, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        username = findViewById(R.id.txtUser);
        email = findViewById(R.id.txtEmail);
        phone = findViewById(R.id.txtPhone);
        pass = findViewById(R.id.txtPass);

    }

    public void saveUser(View view) {
        String names = username.getText().toString();
        String emails = email.getText().toString();
        String phones = phone.getText().toString();
        String passes = pass.getText().toString();

        User user= new User(names,emails,phones,passes);
        user.save();

        Intent intent = new Intent(SignUpActivity.this, SplashActivity.class);
        startActivity(intent);
        finish();
    }
}