package com.example.vaith.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {


    String[] books = new String[] {
            "Java","PHP","SWIFT","NODEJS","WORKFLOW"
    };

    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.drop_down_item,
                books);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.auto);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiauto);
        autoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
