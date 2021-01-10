package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class search extends Activity {

    DBHelper db;
    ArrayList<String> listItem;
    ListView productList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        db = new DBHelper(this);
        listItem = new ArrayList<>();
        productList = findViewById(R.id.productList);
        viewProduct();

        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = productList.getItemAtPosition(1).toString();
                Toast.makeText(search.this, ""+text,Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void viewProduct(){
        Cursor cursor = db.viewProduct();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
                listItem.add(cursor.getString(2));
                listItem.add(cursor.getString(3));

            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listItem);
            productList.setAdapter(adapter);


    }
}