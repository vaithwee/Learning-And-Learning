package com.example.vaith.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Vaith on 16/8/17.
 */
public class BookListFragment extends ListFragment
{
    private Delegate delegate;

    public interface Delegate
    {
        public void onItemSelected(Integer id);
    }

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(), android.R.layout.simple_list_item_activated_1, android.R.id.text1, BookContent.ITEMS));
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (!(activity instanceof  Delegate))
        {
            throw new IllegalStateException("BookListFragment所在的Activity必须实现Delegate接口");
        }
        this.delegate = (Delegate)activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        delegate.onItemSelected(BookContent.ITEMS.get(position).id);
    }

    public void setActivateOnItemClick(boolean activateOnItemClick)
    {
        getListView().setChoiceMode(activateOnItemClick?ListView.CHOICE_MODE_SINGLE:ListView.CHOICE_MODE_NONE);
    }
}
