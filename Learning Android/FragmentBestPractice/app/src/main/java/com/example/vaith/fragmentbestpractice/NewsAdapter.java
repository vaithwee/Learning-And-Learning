package com.example.vaith.fragmentbestpractice;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vaith on 2016/8/3.
 */
public class NewsAdapter extends ArrayAdapter<News>
{
    private int resourceID;
    public NewsAdapter(Context ctx, int resourceID, List<News> objects)
    {
        super(ctx, resourceID, objects);
        this.resourceID = resourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        News news = getItem(position);
        View view;
        if (convertView != null)
        {
            view = convertView;
        }
        else
        {
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
        }

        TextView title = (TextView) view.findViewById(R.id.news_title);
        title.setText(news.getContent());
        return view;
    }
}
