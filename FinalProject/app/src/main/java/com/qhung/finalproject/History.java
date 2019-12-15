package com.qhung.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    Button del, back;
    private ArrayList <String> arrayList;
    MyDatabase db;
    ListView lvres;
    ArrayAdapter <String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        lvres = (ListView) findViewById(R.id.lv_res);
        db = new MyDatabase(this);
        arrayList = db.getAllchuoi();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lvres.setAdapter(adapter);
        del = findViewById(R.id.btn_delete);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deletechuoi();
                arrayList.clear();
                adapter.notifyDataSetChanged();
            }
        });
        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
