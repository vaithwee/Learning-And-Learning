package com.example.vaith.dictionary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vaith on 16/8/23.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper
{
    final String CREATE_TABLE_SQL = "create table dict(_id integer primary key autoincrement , word, detail)";
    public MyDatabaseHelper(Context context, String name, int version)
    {
        super(context, name, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        System.out.println("onUpdate Called----------->"+ i + "------------>" + i1);
    }
}
