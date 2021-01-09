package com.example.mobiventory;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DB1Helper extends SQLiteOpenHelper {
    public DB1Helper(Context context) {
        super(context, "productdata.db", null, 1);

    }

    public DB1Helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Product(pname TEXT primary key, pid TEXT,quantity TEXT ,cost_price TEXT,sell_price TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        //DB.execSQL("drop table if exists Catagory");

    }
   /* public Boolean addcatagory(String catagory)
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

    }*/

    public Boolean addproduct(String pname, String pid, String quantity, String cost_price, String sell_price)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("pname",pname);
        contentValues.put("pid",pid);
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

}