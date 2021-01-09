package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class add_product extends AppCompatActivity {
    EditText pname, mname, quantity, cost_price, sell_price;
    Button Add;
    DBHelper DB;
    Spinner category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        pname =findViewById(R.id.pname);
        mname =findViewById(R.id.mname);
        quantity =findViewById(R.id.quantity);
        cost_price =findViewById(R.id.cost_price);
        sell_price =findViewById(R.id.sell_price);
        category = findViewById(R.id.categoryDD);
        Add=findViewById(R.id.Add);
        DB = new DBHelper(this);

        //category.setOnItemSelectedListener(this);

       // loadSpinnerData();


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pnameTXT =pname.getText().toString();
                String mnameTXT =mname.getText().toString();
                String quantityTXT =quantity.getText().toString();
                String cost_priceTXT =cost_price.getText().toString();
                String sell_priceTXT =sell_price.getText().toString();

                Boolean checkaddproduct = DB.addproduct(pnameTXT, mnameTXT,quantityTXT,cost_priceTXT,sell_priceTXT);
                if (checkaddproduct==true)
                    Toast.makeText(add_product.this, "New Product Added", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(add_product.this, "Not Added", Toast.LENGTH_SHORT).show();




            }
        });
        
    }

//    private void loadSpinnerData() {
//        // database handler
//      //  DatabaseHandler db = new DatabaseHandler(getApplicationContext());
//
//        // Spinner Drop down elements
//        List<String> lables = DB.getAllLabels();
//
//        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, lables);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter
//                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
//        category.setAdapter(dataAdapter);
//    }


}