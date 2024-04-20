
package com.movildev.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Dashboard extends AppCompatActivity {

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
        String name = username.getText().toString();
        List<User> users = User.find(User.class,"username=?", name);
        User user = users.get(0);

        email.setText(user.getEmail());
        pass.setText(user.getPassword());
        phone.setText(user.getPhone());
    }

    public void deleteUser(View view) {

    }

    public void updateUser(View view) {

    }
}