package com.example.vaith.fragmenttest;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Vaith on 16/8/3.
 */
public class RightFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.right_fragment, viewGroup, false);
        return view;
    }
}
