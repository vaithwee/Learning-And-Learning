package com.example.vaith.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Vaith on 16/8/17.
 */
public class BookDetailFragment extends Fragment
{
    public static final String ITEM_ID = "item_id";
    BookContent.Book book;

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.fragment_book_detail, viewGroup, false);

        return view;
    }

    public void setBookId(Integer id)
    {
        this.book = BookContent.ITEM_MAP.get(id);
        View view = getView();
        if (book != null)
        {
            ((TextView)view.findViewById(R.id.book_title)).setText(book.title);
            ((TextView)view.findViewById(R.id.book_desc)).setText(book.desc);
        }
    }

}
