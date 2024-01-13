package com.example.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public  static final  String DATABASE_NAME="uni.db";
    public  static final  String TABLE_NAME="student";
    public  static final  String COLUMN_ID ="id";
    public  static final  String COLUMN_NAME="name";
    public  static final  String COLUMN_SALATY="salary";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME +"( " + COLUMN_ID +" INTEGER PRIMARY KEY ,"
        + COLUMN_NAME +" TEXT NOT NULL ," +
              COLUMN_SALATY +" TEXT NOT NULL )"  );

    }
    public void AddStudent (String id , String name , int salary ){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(COLUMN_ID,id);
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_SALATY,salary);
        db.insert(TABLE_NAME,null,values);
    }
    public Cursor ViewStudent (){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " +TABLE_NAME ,null);
        return cur;

    }
    public Integer DeleteStudent (String id){
        SQLiteDatabase db= this.getWritableDatabase();
        return  db.delete(TABLE_NAME , "ID = ?" , new String[] {id});

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
