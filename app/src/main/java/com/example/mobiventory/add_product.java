package com.example.mobiventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_product extends AppCompatActivity {
    EditText pname, pid, quantity, cost_price, sell_price;
    Button Add;
    DB1Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        pname =findViewById(R.id.pname);
        pid =findViewById(R.id.pid);
        quantity =findViewById(R.id.quantity);
        cost_price =findViewById(R.id.cost_price);
        sell_price =findViewById(R.id.sell_price);

        Add=findViewById(R.id.Add);
        DB = new DB1Helper(this);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pnameTXT =pname.getText().toString();
                String pidTXT =pid.getText().toString();
                String quantityTXT =quantity.getText().toString();
                String cost_priceTXT =cost_price.getText().toString();
                String sell_priceTXT =sell_price.getText().toString();

                Boolean checkaddproduct = DB.addproduct(pnameTXT, pidTXT,quantityTXT,cost_priceTXT,sell_priceTXT);
                if (checkaddproduct==true)
                    Toast.makeText(add_product.this, "New Product Added", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(add_product.this, "Not Added", Toast.LENGTH_SHORT).show();




            }
        });

    }
}