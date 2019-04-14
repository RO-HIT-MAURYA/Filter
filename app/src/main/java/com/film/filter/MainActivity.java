package com.film.filter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<AndroidVersion> items = new ArrayList<>();
        items.add(new AndroidVersion("one","name1"));
        items.add(new AndroidVersion("two","name2"));

        final ListView listView = findViewById(R.id.listView);

        listView.setAdapter(new MyAdapter(this,R.layout.list_item,items));

        ((EditText)findViewById(R.id.editText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                ArrayList<AndroidVersion> results = new ArrayList<>();
                for (AndroidVersion androidVersion: items)
                {
                    if (androidVersion.s.contains(s.toString()))
                        results.add(androidVersion);
                }
                ((MyAdapter)listView.getAdapter()).update(results);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
