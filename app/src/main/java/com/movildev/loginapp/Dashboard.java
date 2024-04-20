
package com.movildev.loginapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Dashboard extends AppCompatActivity {
    private String TAG = "LoginActivity";
    EditText username, email, phone, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        username = findViewById(R.id.editTextText4);
        email = findViewById(R.id.editTextTextEmailAddress);
        phone = findViewById(R.id.editTextTextPassword);
        pass = findViewById(R.id.editTextPhone);
    }

    public void findUser(View view) {
        try {
            String name = username.getText().toString();
            List<User> users = User.find(User.class,"username=?", name);
            User user = users.get(0);

            email.setText(user.getEmail());
            pass.setText(user.getPassword());
            phone.setText(user.getPhone());
        } catch (Exception e) {
            Log.d(TAG, "error find:"+e);
        }
    }

    public void deleteUser(View view) {
        try {
            String name = username.getText().toString();
            List<User> users = User.find(User.class,"username=?", name);
            User user = users.get(0);
            user.delete();
        } catch (Exception e) {
            Log.d(TAG, "error delete:"+e);
        }

    }

    public void updateUser(View view) {
        try {
            String name = username.getText().toString();
            List<User> users = User.find(User.class,"username=?", name);
            User user = users.get(0);
            user.username = username.getText().toString();
            user.email = email.getText().toString();
            user.phone = phone.getText().toString();
            user.password = pass.getText().toString();
            user.save();
        } catch (Exception e) {
            Log.d(TAG, "error update:"+e);
        }
    }
}