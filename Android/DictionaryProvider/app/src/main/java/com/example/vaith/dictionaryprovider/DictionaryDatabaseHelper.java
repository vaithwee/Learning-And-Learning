package com.example.vaith.dictionaryprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vaith on 16/8/25.
 */
public class DictionaryDatabaseHelper extends SQLiteOpenHelper
{
    final String CREATE_TABLE_SQL = "CREATE TABLE dict(_id integer primary key autoincrement, word, detail)";
    public DictionaryDatabaseHelper(Context context, String name, int version)
    {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
