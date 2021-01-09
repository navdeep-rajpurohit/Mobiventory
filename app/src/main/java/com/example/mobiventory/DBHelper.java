package com.example.mobiventory;

import      android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Catagory(catagory TEXT)");
        DB.execSQL("create table Product(pname TEXT primary key, mname TEXT,quantity TEXT ,cost_price TEXT,sell_price TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists Catagory");
        DB.execSQL("drop table if exists Product");

    }

    public Boolean addcatagory(String catagory)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("catagory",catagory);
        long result=DB.insert("Catagory",null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }

    }

    public Boolean addproduct(String pname, String mname, String quantity, String cost_price, String sell_price)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("pname",pname);
        contentValues.put("mname",mname);
        contentValues.put("quantity",quantity);
        contentValues.put("cost_price",cost_price);
        contentValues.put("sell_price",sell_price);
        long result=DB.insert("Product",null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }


    }


    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM Catagory";

        SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }
}
