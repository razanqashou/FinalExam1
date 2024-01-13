package com.example.afinal;

import android.app.AppComponentFactory;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class List extends AppCompatActivity {
    private DatabaseHelper db;
    private ArrayList<String> userID,  username, salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = new DatabaseHelper(this);
        userID = new ArrayList<>();
        username = new ArrayList<>();
        salary = new ArrayList<>();
        storeData();
        ListView lst = findViewById(R.id.list);
        HashMap<String, String> res = new HashMap<>();
        for (int i = 0; i < userID.size(); i++) {
            res.put(userID.get(i),username.get(i));
        }
        java.util.List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                listItems, R.layout.item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.userIdItem, R.id.messageTitleItem}
        );

        for (String key : res.keySet()) {
            HashMap<String, String> pair = new HashMap<>();
            pair.put("First Line", key);
            pair.put("Second Line", res.get(key));
            listItems.add(pair);
        }

        lst.setAdapter(adapter);
        Toast.makeText(this, db.getStatus(), Toast.LENGTH_SHORT).show();

    }

    private void storeData() {
        Cursor cursor = db.ViewStudent();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "The Database is empty.", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                userID.add(cursor.getString(0));
               username.add(cursor.getString(1));
                salary.add(cursor.getString(2));

            }
        }
    }
}