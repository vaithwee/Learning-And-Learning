package com.example.vaith.databasetest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Vaith on 16/8/5.
 */
public class DatabaseProvider extends ContentProvider {
    public static final int BOOK_DIR = 0;
    public static final int BOOK_ITEM = 1;
    public static final int CATEGORY_DIR = 2;
    public static final int CATEGORY_ITEM = 3;

    public static final String AUTHORITY = "com.example.vaith.databasetest.provider";

    private  MyDatabaseHelper databaseHelper;

    private static UriMatcher uriMatcher;
    static
    {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "book", BOOK_DIR);
        uriMatcher.addURI(AUTHORITY, "book#", BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY, "category", CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY, "category#", CATEGORY_ITEM);
    }

    @Override
    public boolean onCreate()
    {
        databaseHelper = new MyDatabaseHelper(getContext(), "BookStore.db", null, 2);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri))
        {
            case BOOK_DIR:
                cursor = database.query("book", projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case BOOK_ITEM:
                String bookID = uri.getPathSegments().get(1);
                cursor = database.query("book", projection, "id = ?", new String[] {bookID}, null, null, sortOrder);
                break;
            case CATEGORY_DIR:
                cursor = database.query("category", projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CATEGORY_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                cursor = database.query("category", projection, "id = ?", new String[] { categoryId }, null, null, sortOrder);
                break;
            default:
                break;
        }
        return cursor;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Uri uriReturn = null;
        switch (uriMatcher.match(uri))
        {
            case BOOK_DIR:
            case BOOK_ITEM:
            {
                long newBookId = database.insert("book", null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/book/" + newBookId);
                break;
            }
            case CATEGORY_DIR:
            case CATEGORY_ITEM:
            {
                long newCategoryId = database.insert("category", null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/category/" + newCategoryId);
                break;
            }
            default:
                break;
        }
        return uriReturn;
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] seletionArgs)
    {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        int updateRows = 0;
        switch (uriMatcher.match(uri))
        {
            case BOOK_DIR:
            {
                updateRows = database.update("book", values, selection, seletionArgs);
                break;
            }
            case BOOK_ITEM:
            {
                String bookId = uri.getPathSegments().get(1);
                updateRows = database.update("book", values, "id = ?", new String[] { bookId});
                break;
            }
            case CATEGORY_DIR:
            {
                updateRows = database.update("category", values, selection, seletionArgs);
                break;
            }
            case CATEGORY_ITEM:
            {
                String categoryId = uri.getPathSegments().get(1);
                updateRows = database.update("category", values, "id = ?", new String[] { categoryId});
                break;
            }
            default:
                break;
        }
        return updateRows;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        int delectedRows = 0;
        switch (uriMatcher.match(uri))
        {
            case BOOK_DIR:
            {
                delectedRows = database.delete("book", selection, selectionArgs);
                break;
            }
            case BOOK_ITEM:
            {
                String bookId = uri.getPathSegments().get(1);
                delectedRows = database.delete("book", "id = ?", new String[] {bookId});
                break;
            }
            case CATEGORY_DIR:
            {
                delectedRows = database.delete("category", selection, selectionArgs);
                break;
            }
            case CATEGORY_ITEM:
            {
                String categoryId = uri.getPathSegments().get(1);
                delectedRows = database.delete("category", "id = ?", new String[] {categoryId});
                break;
            }
            default:
                break;
        }
        return delectedRows;
    }

    @Override
    public String getType(Uri uri)
    {
        switch (uriMatcher.match(uri))
        {
            case BOOK_DIR:
                return "vnd.android.cursor.dir/com.example.vaith.databasetest.provider.book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/com.example.vaith.databasetest.provider.book";
            case CATEGORY_DIR:
                return "vnd.android.cursor.dir/com.example.vaith.databasetest.provider.category";
            case CATEGORY_ITEM:
                return "vnd.android.cursor.item/com.example.vaith.databasetest.provider.category";
        }
        return null;
    }

}
