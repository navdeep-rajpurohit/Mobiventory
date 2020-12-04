package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
 //       EditText username = (EditText)findViewById(R.id.usernameTB);
  //      EditText password = (EditText)findViewById(R.id.passwordTB);
    }

    public void dashboardact(View view) {
        Intent intent = new Intent(this, dashboard.class);
         startActivity(intent);
        Toast msg = Toast.makeText(getBaseContext(), "Loggged in.", Toast.LENGTH_LONG);
        msg.show();
//        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
//            Intent intent = new Intent(this, dashboard.class);
//            startActivity(intent);
//
//        }
//        else
//        {
//
//        }
    }

}