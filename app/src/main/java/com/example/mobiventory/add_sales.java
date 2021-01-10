package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class add_sales extends Activity implements AdapterView.OnItemSelectedListener {
    EditText cname,price,cPrice;
    Button sale;
    DBHelper DB;
    Spinner products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sales);

        cname = findViewById(R.id.cName);
        price = findViewById(R.id.price);
        cPrice = findViewById(R.id.cPrice);
        sale = findViewById(R.id.sale);
        products= findViewById(R.id.productDD);
        DB = new DBHelper(this);

        products.setOnItemSelectedListener(this);
       loadSpinnerData();

        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cnameTXT = cname.getText().toString();
                String priceTXT = price.getText().toString();
                String cpriceTXT = cPrice.getText().toString();
                String productTXT = products.getSelectedItem().toString();
                Boolean checkaddsales = DB.addsales(cnameTXT, priceTXT,cpriceTXT,productTXT);
                if (checkaddsales==true)
                    Toast.makeText(add_sales.this, "New Product Sold", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(add_sales.this, "Failed", Toast.LENGTH_SHORT).show();




            }
        });

    }
    private void loadSpinnerData() {
        // database handler
        DBHelper db = new DBHelper (getApplicationContext());

        // Spinner Drop down elements
        List<String> projects = db.getAllProducts();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, projects);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        products.setAdapter(dataAdapter);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        String selected = (String)parent.getItemAtPosition(pos);

        DB = new DBHelper(this);
        int cpsp[] = DB.cpspSales(selected);
        String cp = Integer.toString(cpsp[0]);
        String sp = Integer.toString(cpsp[1]);

        price.setText(sp);
        cPrice.setText(cp);

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}