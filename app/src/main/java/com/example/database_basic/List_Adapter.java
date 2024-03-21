package com.example.database_basic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class List_Adapter extends BaseAdapter {
    MainActivity mainActivity;
    ArrayList<Integer> listid;
    ArrayList<String> listname;
    ArrayList<String> listnumber;

    public List_Adapter(MainActivity mainActivity, ArrayList<Integer> listid, ArrayList<String> listname, ArrayList<String> listnumber) {
        this.mainActivity = mainActivity;
        this.listid = listid;
        this.listname = listname;
        this.listnumber = listnumber;
    }

    @Override
    public int getCount() {

        return listname.size();
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(mainActivity).inflate(R.layout.listview_item,parent,false);
        TextView t1=view.findViewById(R.id.ID);
        TextView t2=view.findViewById(R.id.NAME);
        TextView t3=view.findViewById(R.id.NUMBER);

        t1.setText(listid.get(position).toString());
        t2.setText(listname.get(position));
        t3.setText(listnumber.get(position));

        return view;
    }
}
