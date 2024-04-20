package com.movildev.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private String TAG = "LoginActivity";
    private EditText username , password, email, phone;
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

    public void SignIn (View view){
        String name = username.getText().toString();
        String pass = password.getText().toString();
        try {
            List<User> users = User.find(User.class,"username=?", name);
            User user = users.get(0);
            if (user.getPassword().equals(pass)) {
                Intent intent = new Intent(LoginActivity.this, SplashActivity.class);
                startActivity(intent);
                finish();
            } else {
                // Contraseña incorrecta
                Toast.makeText(LoginActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.d(TAG,"login error:"+e);
        }

    }

}

