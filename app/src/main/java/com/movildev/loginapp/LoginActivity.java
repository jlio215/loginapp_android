package com.movildev.loginapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private String TAG = "LoginActivity";
    private EditText username , password;
    private Button btnsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.txtusername);
        password = findViewById(R.id.txtpassword);
        btnsignin = findViewById(R.id.buttonsignin);
    }

    public void SignIn (View v){

    }

}