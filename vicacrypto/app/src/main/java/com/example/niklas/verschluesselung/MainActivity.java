package com.example.niklas.verschluesselung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Created by: NIKLAS LEINZ
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Caesar Verfahren");
        menu.add("Vignere Verfahren");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menu);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) {
                    Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                    //intent.putExtra("name", "Test");
                    startActivity(intent);
                }
                if (position==1) {
                    Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                    //intent.putExtra("name", "Test");
                    startActivity(intent);
                }
            }
        });
    }
}
