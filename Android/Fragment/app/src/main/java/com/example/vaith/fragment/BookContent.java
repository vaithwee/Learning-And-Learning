package com.example.vaith.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vaith on 16/8/17.
 */
public class BookContent
{
    public  static class Book
    {
        public Integer id;
        public String title;
        public String desc;

        public Book(Integer id, String title, String desc)
        {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString()
        {
            return title;
        }

    }

    public static List<Book> ITEMS = new ArrayList<Book>();
    public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();
    static
    {
        addItem(new Book(1, "疯狂Java讲义","一本全面、深入的Java学习图书，已被多家高校选做教材"));
        addItem(new Book(2, "疯狂Android讲义","Android学习者的首选图书,常年占据京东、当当、亚马逊三大网站Android销量排行榜首"));
        addItem(new Book(3, "100Swift Tips","猫神的Swift小题是"));

    }

    public static void addItem(Book book)
    {
        ITEMS.add(book);
        ITEM_MAP.put(book.id, book);
    }

}
