package com.example.vaith.fragment;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements BookListFragment.Delegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemSelected(Integer id) {
        BookDetailFragment fragment = (BookDetailFragment) getSupportFragmentManager().findFragmentById(R.id.book_detail);
        fragment.setBookId(id);
    }
}
