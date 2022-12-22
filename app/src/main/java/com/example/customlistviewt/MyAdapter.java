package com.example.customlistviewt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private final Context context;
    private final List<Country> dataSource;

    public MyAdapter(Context context, List<Country> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        }
        // Bind ID
        ImageView img = view.findViewById(R.id.imgCountry);
        TextView tv = view.findViewById(R.id.tvCountry);
        // Do du lieu vao view
        Country country = dataSource.get(i);

        tv.setText(country.getName());
        Picasso.get().load(country.getImageURL()).into(img);

        return view;
    }
}
