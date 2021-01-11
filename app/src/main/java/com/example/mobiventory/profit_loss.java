package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class profit_loss extends AppCompatActivity {
    TextView sellprice,costprice,profit;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit_loss);
        sellprice = findViewById(R.id.sptb);
        costprice = findViewById(R.id.cptb);
        profit = findViewById(R.id.profit);
        DB = new DBHelper(this);
        int price[] = DB.profitloss();
        String cnvr1 = Integer.toString(price[0]);
        String cnvr2 = Integer.toString(price[1]);
        String pro = Integer.toString(price[0]-price[1]);
        sellprice.setText(cnvr1);
        costprice.setText(cnvr2);
        profit.setText(pro);
        if(price[0]>=price[1])
        {
            profit.setTextColor(0xff008000);
        }
        else
        {
            profit.setTextColor(0xffff0000);
        }

    }
}