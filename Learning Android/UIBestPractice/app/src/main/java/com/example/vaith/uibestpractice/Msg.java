package com.example.vaith.uibestpractice;

/**
 * Created by Vaith on 16/8/3.
 */
public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;
    private String content;
    private int type;

    public Msg(String ctx, int type)
    {
        this.content = ctx;
        this.type = type;
    }

    public String getContent()
    {
        return this.content;
    }

    public int getType()
    {
        return this.type;
    }
}
