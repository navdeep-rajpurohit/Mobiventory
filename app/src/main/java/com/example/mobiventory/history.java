package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class history extends AppCompatActivity {
    DBHelper db;
    ArrayList<String> listItem;
    ListView sales;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        db = new DBHelper(this);
        listItem = new ArrayList<>();
        sales = findViewById(R.id.salesLV);
        viewSales();

    }

    private void viewSales(){
        Cursor cursor = db.viewSales();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else
            while (cursor.moveToNext()){

                listItem.add("Customer Name");
                listItem.add(cursor.getString(0));
                listItem.add("Model Number");
                listItem.add(cursor.getString(1));
                listItem.add("Sell Price");
                listItem.add(cursor.getString(2));
                sales.setDividerHeight(10);


            }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listItem);
        sales.setAdapter(adapter);
        sales.setDividerHeight(0);

    }
}