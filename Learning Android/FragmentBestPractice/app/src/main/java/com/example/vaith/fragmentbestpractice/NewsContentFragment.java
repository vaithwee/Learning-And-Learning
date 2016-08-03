package com.example.vaith.fragmentbestpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Vaith on 2016/8/3.
 */
public class NewsContentFragment extends Fragment {

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle)
    {
        view = inflater.inflate(R.layout.news_content_frag, viewGroup, false);
        return view;
    }


    public void refresh(String title, String content)
    {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView titleLabel = (TextView) view.findViewById(R.id.news_title);
        TextView contentLabel = (TextView) view.findViewById(R.id.news_content);
        titleLabel.setText(title);
        contentLabel.setText(content);
    }
}
