package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginact(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void signupact(View view) {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

}