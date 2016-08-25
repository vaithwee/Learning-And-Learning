package com.example.vaith.dictionaryprovider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Vaith on 16/8/25.
 */
public final class Words
{
    public static final String AUTHORITY = "xyz.vaith.providers.dictionaryprovider";

    public static final class Word implements BaseColumns
    {
        public final static String _ID = "_id";
        public final static String WORD = "word";
        public final static String DETAIL = "detail";
        public final static Uri DICT_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/words");
        public final static Uri WORD_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/word");
    }
}
