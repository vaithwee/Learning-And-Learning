package com.example.vaith.dictionaryprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Vaith on 16/8/25.
 */
public class DictionayProvider extends ContentProvider {
    private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH) ;
    private static final int WORDS = 1;
    private static final int WORD = 2;
    private DictionaryDatabaseHelper databaseHelper;

    static {
        matcher.addURI(Words.AUTHORITY, "words", WORDS);
        matcher.addURI(Words.AUTHORITY, "word/#", WORD);
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new DictionaryDatabaseHelper(this.getContext(), "dictionary.db3", 1);
        return true;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (matcher.match(uri)) {
            case WORDS:
                return "vnd.android.cursor.dir/xyz.vaith.dict";
            case WORD:
                return "vnd.android.cursor.item/xyz.vaith.dict";
            default:
                throw new IllegalArgumentException("unkonwn uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String where, String[] whereArgs, String sortOrder) {
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        switch (matcher.match(uri)) {
            case WORDS:
                return database.query("dict", projection, where, whereArgs, null, null, sortOrder);
            case WORD:
                long id = ContentUris.parseId(uri);
                String whereCaluse = Words.Word._ID + "=" + id;
                if (where != null && !"".equals(where)) {
                    whereCaluse = whereCaluse + " and " + where;
                }
                return database.query("dict", projection, whereCaluse, whereArgs, null, null, sortOrder);
            default:
                throw new IllegalArgumentException("unkown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        switch (matcher.match(uri))
        {
            case WORDS:
                long rowId = database.insert("dict", Words.Word._ID, contentValues);
                if (rowId > 0)
                {
                    Uri wordUri = ContentUris.withAppendedId(uri, rowId);
                    getContext().getContentResolver().notifyChange(wordUri, null);
                    return wordUri;
                }
                break;
            default:
                throw new IllegalArgumentException("unkonw uri: " + uri);
        }
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String where, String[] whereArgs) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        int num = 0;
        switch (matcher.match(uri))
        {
            case WORDS:
                num = database.update("dict", contentValues, where, whereArgs);
                break;
            case WORD:
                long id = ContentUris.parseId(uri);
                String whereCaluse = Words.Word._ID + "=" + id;
                if (where != null && !where.equals(""))
                {
                    whereCaluse = whereCaluse + " and " + where;
                }
                num = database.update("dict", contentValues, whereCaluse, whereArgs);
                break;
            default:
                throw new IllegalArgumentException("unkonw uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return num;

    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        int num = 0;
        switch (matcher.match(uri))
        {
            case WORDS:
                num = database.delete("dict", where, whereArgs);
                break;
            case WORD:
                long id = ContentUris.parseId(uri);
                String whereClause = Words.Word._ID + "=" + id;
                if (where != null && !where.equals(""))
                {
                    whereClause = whereClause + " and " + where;
                }
                num = database.delete("dict", whereClause, whereArgs);
                break;
            default:
                throw new IllegalArgumentException("unkonw uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return num;
    }
}
