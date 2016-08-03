package com.example.vaith.fragmenttest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Vaith on 16/8/3.
 */
public class AnotherRightFrame extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.another_right_fragment, parent, false);
        return view;
    }
}
