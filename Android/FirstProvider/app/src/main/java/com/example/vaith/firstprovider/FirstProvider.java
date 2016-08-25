package com.example.vaith.firstprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.Nullable;

/**
 * Created by Vaith on 16/8/25.
 */
public class FirstProvider extends ContentProvider
{
    @Override
    public boolean onCreate() {
        System.out.println("-----------OnCreate FirstProvider--------------");
        return false;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        System.out.println("-----------Query FirstProvider--------------");
        System.out.println("Uri:" + uri);
        System.out.println("selection: " + selection);
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        System.out.println("-----------Insert FirstProvider--------------");
        System.out.println("Uri:" + uri);
        System.out.println("values: "+ contentValues);
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        System.out.println("-----------Update FirstProvider--------------");
        System.out.println("Uri:" + uri);
        System.out.println("where: " + s + " values: " + contentValues);
        return 0;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        System.out.println("-----------Delete FirstProvider--------------");
        System.out.println("Uri:" + uri);
        System.out.println("where: " + s);
        return 0;
    }
}
