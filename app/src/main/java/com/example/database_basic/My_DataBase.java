package com.example.database_basic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class My_DataBase extends SQLiteOpenHelper {

    public My_DataBase(Context context) {
        super(context, "Contacts", null, 1);
        Log.d("AAA", "My_DataBase:Database Created ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table Contact (ID integer primary key autoincrement,NAME text, NUMBER text)";
        db.execSQL(query);
        Log.d("AAA", "My_DataBase:Table Created ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(String name, String number) {
        String query="insert into Contact(NAME,NUMBER)values('"+name+"','"+number+"')";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }

    public Cursor showdata() {
        String query="select * from Contact";
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        return  cursor;
    }

    public void deleteContact(int id) {
        String query="delete from Contact where ID="+id;
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }

    public void updatedata(int id, String name, String number) {
        String query="update Contact set NAME='"+name+"',NUMBER='"+number+"' where ID="+id+"";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }
}
