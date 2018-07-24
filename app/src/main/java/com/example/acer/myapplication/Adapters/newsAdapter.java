package com.example.acer.myapplication.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.acer.myapplication.Main2Activity;
import com.example.acer.myapplication.Models.NewsListItem;
import com.example.acer.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class newsAdapter extends BaseAdapter{

    List<NewsListItem> list;
    Context context;
    Activity activity;

    public newsAdapter(List<NewsListItem> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView idt=convertView.findViewById(R.id.id);
        TextView titlet=convertView.findViewById(R.id.title);
        TextView subtitlet=convertView.findViewById(R.id.subtitle);
        TextView writert=convertView.findViewById(R.id.writer);
        ImageView imageı=convertView.findViewById(R.id.image);
        RelativeLayout layout=convertView.findViewById(R.id.relative);
        Picasso.get().load(""+list.get(position).getImage()).into(imageı);
        idt.setText(""+list.get(position).getId());
        titlet.setText(""+list.get(position).getTitle());
        subtitlet.setText(""+list.get(position).getSubTitle());
        writert.setText(""+list.get(position).getWriter());
        final String idm=""+list.get(position).getId();

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, Main2Activity.class);
                intent.putExtra("id",idm);
                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}

