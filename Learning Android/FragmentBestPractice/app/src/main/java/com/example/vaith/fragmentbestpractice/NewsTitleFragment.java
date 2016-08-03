package com.example.vaith.fragmentbestpractice;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vaith on 2016/8/3.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView listView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = getNews();
        adapter = new NewsAdapter(activity, R.layout.news_listview_item, newsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.news_title_frag, viewGroup, false);
        listView = (ListView) view.findViewById(R.id.news_title_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        isTwoPane = false;
//        if (getActivity().findViewById(R.id.new))
//        {
//
//        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        News news = newsList.get(position);
        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setTitle("Succeed in College as a Learning Disabled Student");
        news1.setContent("College freshmen will soon learn to live with a    roommate, adjust to a new social scene and survive less-than-stellar    dining hall food. Students with learning disabilities will face these    transitions while also grappling with a few more hurdles.");
        newsList.add(news1);
        News news2 = new News();
        news2.setTitle("Google Android exec poached by China's Xiaomi");
        news2.setContent("China's Xiaomi has poached a key Google executive    involved in the tech giant's Android phones, in a move seen as a coup    for the rapidly growing Chinese smartphone maker.");
        newsList.add(news2);
        return newsList;
    }
}
