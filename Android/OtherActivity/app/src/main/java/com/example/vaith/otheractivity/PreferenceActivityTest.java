package com.example.vaith.otheractivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;

import java.util.List;

/**
 * Created by Vaith on 16/8/16.
 */
public class PreferenceActivityTest extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle bundle)
    {
        if (hasHeaders())
        {
            Button button = new Button(this);
            button.setText("设置操作");
            setListFooter(button);
        }
    }

    @Override
    public void onBuildHeaders(List<Header> target)
    {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }

    @Override
    public boolean isValidFragment(String fragmentName)
    {
        return true;
    }

    public static class Prefs1Fragment extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle bundle)
        {
            super.onCreate(bundle);

        }

    }


}
