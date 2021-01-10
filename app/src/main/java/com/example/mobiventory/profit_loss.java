package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class profit_loss extends AppCompatActivity {
    TextView sellprice,costprice;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit_loss);
        sellprice = findViewById(R.id.sptb);
        costprice = findViewById(R.id.cptb);
        DB = new DBHelper(this);
        int price[] = DB.profitloss();
        String cnvr1 = Integer.toString(price[0]);
        String cnvr2 = Integer.toString(price[1]);

        sellprice.setText(cnvr1);
        costprice.setText(cnvr2);

    }
}