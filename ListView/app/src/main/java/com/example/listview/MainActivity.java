package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        initListview();
    }

    private void initListview(){
        LinkedList<HashMap<String,String>> data = new LinkedList<>();
        String[] from = {"title"};
        int[] to = {R.id.item_title};

        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"Test1");
        data.add(d0);


        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.item,from,to);
        listView.setAdapter(adapter);
    }

    public void add(View view) {
    }

    public void del(View view) {
    }
}