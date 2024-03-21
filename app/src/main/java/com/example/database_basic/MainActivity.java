package com.example.database_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    ArrayList<Integer>listid=new ArrayList<>();
    ArrayList<String>listname=new ArrayList<>();
    ArrayList<String>listnumber=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);

        My_DataBase dataBase=new My_DataBase(MainActivity.this);
        dataBase.addContact("Asmita","963852741");
        dataBase.addContact("Heli","8763240981");
        dataBase.addContact("priyanka","8763240981");
        dataBase.addContact("Abc","8763240981");

        Cursor cursor=dataBase.showdata();
        Log.d("AAA", "onCreate: showdata"+cursor);

        dataBase.deleteContact(6);
       dataBase.updatedata(3,"CCC","7878787878");
        while (cursor.moveToNext())
        {
            listid.add(cursor.getInt(0));
            listname.add(cursor.getString(1));
            listnumber.add(cursor.getString(2));
            Log.d("AAA", "onCreate: "+listid+" "+listname+" "+listnumber);
            
        }

       List_Adapter adapter=new List_Adapter(MainActivity.this,listid,listname,listnumber);
        listView.setAdapter(adapter);
    }
}