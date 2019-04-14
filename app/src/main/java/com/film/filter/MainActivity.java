package com.film.filter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<AndroidVersion> items = new ArrayList<>();
        items.add(new AndroidVersion("one","name1"));
        items.add(new AndroidVersion("two","name2"));

        ((ListView)findViewById(R.id.listView)).setAdapter(new MyAdapter(this,R.layout.list_item,items));
    }
}
