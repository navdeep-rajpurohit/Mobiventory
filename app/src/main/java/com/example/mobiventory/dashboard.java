package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dashboard extends AppCompatActivity implements View.OnClickListener {
    public CardView card1,card2,card3,card4,card5,card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//code for toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//code for "using intent in cardview"
        card1 =(CardView) findViewById(R.id.c1);
        card2 =(CardView) findViewById(R.id.c2);
        card3 =(CardView) findViewById(R.id.c3);
        card4 =(CardView) findViewById(R.id.c4);
        card5 =(CardView) findViewById(R.id.c5);
        card6 =(CardView) findViewById(R.id.c6);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.c1:
                i=new Intent(this,add_catagory.class);
                startActivity(i);
                break;
            case R.id.c2:
                i=new Intent(this,add_product.class);
                startActivity(i);
                break;
            case R.id.c3:
                i=new Intent(this,add_sales.class);
                startActivity(i);
                break;
            case R.id.c4:
                i=new Intent(this,history.class);
                startActivity(i);
                break;
            case R.id.c5:
                i=new Intent(this,profit_loss.class);
                startActivity(i);
                break;
            case R.id.c6:
                i=new Intent(this,search.class);
                startActivity(i);
                break;



        }

    }
}