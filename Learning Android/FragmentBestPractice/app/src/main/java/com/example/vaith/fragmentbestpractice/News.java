package com.example.vaith.fragmentbestpractice;

/**
 * Created by Vaith on 2016/8/3.
 */
public class News {
    private String title;
    private String content;
    /*获取标题*/
    public String getTitle()
    {
        return this.title;
    }

    /*获取内容*/
    public String getContent()
    {
        return this.content;
    }

    /*设置标题*/
    public void setTitle(String title)
    {
        this.title = title;
    }

    /*设置内容*/
    public void setContent(String content)
    {
        this.content = content;
    }
}
