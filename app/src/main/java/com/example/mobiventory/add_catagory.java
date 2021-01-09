package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_catagory extends AppCompatActivity {

    EditText catagory;
    Button add;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_catagory);

        catagory=findViewById(R.id.editText1);

        add=findViewById(R.id.button1);
        DB = new DBHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String catagoryTXT =catagory.getText().toString();

                Boolean checkaddcatagory = DB.addcatagory(catagoryTXT);
                if(checkaddcatagory==true)
                    Toast.makeText(add_catagory.this, "New catagory inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(add_catagory.this, "Not inserted", Toast.LENGTH_SHORT).show();

            }
        });


    }
}