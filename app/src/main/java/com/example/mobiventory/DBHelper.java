package com.example.mobiventory;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Catagory(name TEXT)");
        DB.execSQL("create table Product(pname TEXT primary key, mname TEXT,quantity TEXT ,cost_price TEXT,sell_price TEXT,category TEXT)");
        DB.execSQL("create table Sales(cname TEXT,product TEXT,price TEXT,cPrice TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists Catagory");
        DB.execSQL("drop table if exists Product");
        DB.execSQL("drop table if exists Sales");

    }

    public Boolean addcatagory(String catagory)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",catagory);
        long result=DB.insert("Catagory",null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }

    }

    public Boolean addproduct(String pname, String mname, String quantity, String cost_price, String sell_price,String category) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pname", pname);
        contentValues.put("mname", mname);
        contentValues.put("quantity", quantity);
        contentValues.put("cost_price", cost_price);
        contentValues.put("sell_price", sell_price);
        contentValues.put("category", category);
        long result = DB.insert("Product", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
        public Boolean addsales(String cname, String price,String cPrice, String product)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues= new ContentValues();
            contentValues.put("cname",cname);
            contentValues.put("price",price);
            contentValues.put("cPrice",cPrice);
            contentValues.put("product",product);
            long result=DB.insert("Sales",null,contentValues);
            if (result==-1){
                return false;
            }else {
                return true;
            }



        }

    public Cursor viewProduct() {
        SQLiteDatabase DB = this.getReadableDatabase();
        String query = "Select * from Product";
        Cursor cursor = DB.rawQuery(query, null);
        return cursor;
    }

    public List<String> getAllCategory(){
        List<String> projects = new ArrayList<String>();

        String selectQuery = "SELECT * FROM Catagory";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                projects.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return projects;
    }

    public List<String> getAllProducts(){
        List<String> products = new ArrayList<String>();

        String selectQuery = "SELECT * FROM Product";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                products.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return products;
    }


    public int[] profitloss(){
        int[] total = new int[2];
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor1 = DB.rawQuery(
                "SELECT SUM(price) as Total FROM Sales", null);

        if (cursor1.moveToFirst()) {

            total[0] = cursor1.getInt(cursor1.getColumnIndex("Total"));

        }

        Cursor cursor2 = DB.rawQuery(
                "SELECT SUM(cPrice) as Total FROM Sales", null);

        if (cursor2.moveToFirst()) {

            total[1] = cursor2.getInt(cursor2.getColumnIndex("Total"));

        }
        return total;

        }

    public int[] cpspSales(String pname){
        int[] cpsp = new int[2];
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor1 = DB.rawQuery(
                "SELECT cost_price as CP FROM Product where pname ='"+pname+"'", null);

        if (cursor1.moveToFirst()) {

            cpsp[0] = cursor1.getInt(cursor1.getColumnIndex("CP"));

        }

        Cursor cursor2 = DB.rawQuery(
                "SELECT sell_price as SP FROM Product where pname ='"+pname+"'", null);

        if (cursor2.moveToFirst()) {

            cpsp[1] = cursor2.getInt(cursor2.getColumnIndex("SP"));

        }
        return cpsp;

    }





}
