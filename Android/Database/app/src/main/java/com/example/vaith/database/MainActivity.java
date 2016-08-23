package com.example.vaith.database;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    Button show;
    ListView tableView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString() + "/my.db3", null);
        tableView = (ListView) findViewById(R.id.tableview);
        show = (Button) findViewById(R.id.show);
        assert show != null;
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = ((EditText) findViewById(R.id.title)).getText().toString();
                String content = ((EditText) findViewById(R.id.content)).getText().toString();
                try {
                    insertData(database, title, content);
                    Cursor cursor = database.rawQuery("select * from news_inf", null);
                    infalteList(cursor);
                } catch (SQLiteException e){
                    e.printStackTrace();
                    database.execSQL("CREATE TABLE news_inf (_id integer primary key autoincrement, news_title varchar(50), news_content varchar(255))");
                    insertData(database, title, content);
                    Cursor cursor = database.rawQuery("SELECT * FROM news_inf", null);
                    infalteList(cursor);
                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private void infalteList(Cursor cursor)
    {
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this, R.layout.cell, cursor, new String[] {"news_title", "news_content"}, new int[] {R.id.title, R.id.content}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        tableView.setAdapter(adapter);

    }



    private void insertData(SQLiteDatabase db, String title, String content)
    {
        database.execSQL("insert into news_inf values (null, ?, ?)", new String[]{title, content});
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.vaith.database/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.vaith.database/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
