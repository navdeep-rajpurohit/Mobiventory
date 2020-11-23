package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText username = (EditText)findViewById(R.id.usernameTB);
        EditText password = (EditText)findViewById(R.id.passwordTB);
    }

    public void dashboardact(View view) {
        Intent intent = new Intent(this, dashboard.class);
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            startActivity(intent);
        }
        else
        {

        }
    }

}