package com.film.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter
{
    ArrayList<AndroidVersion> items;

    public MyAdapter(Context context, int layout, ArrayList<AndroidVersion> items) {
        super(context, layout);
        this.items = items;
    }

    public class ViewHolder
    {
        TextView textView1 , textView2;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row;
        row = convertView;
        ViewHolder viewHolder;

        if (row == null)
        {
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.textView1 = row.findViewById(R.id.tV1);
            viewHolder.textView2 = row.findViewById(R.id.tV2);
            row.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)row.getTag();
        }
        viewHolder.textView1.setText(items.get(position).s);
        viewHolder.textView2.setText(items.get(position).string);

        return row;
    }

    public void update(ArrayList<AndroidVersion> r)
    {
        items = new ArrayList<>();
        items.addAll(r);
        notifyDataSetChanged();
    }
}
