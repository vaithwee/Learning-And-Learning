package com.example.vaith.bundle;

import java.io.Serializable;

/**
 * Created by Vaith on 16/8/16.
 */
public class Person implements Serializable {
    String name;
    String password;
    String gender;

    public Person(String name, String password, String gender)
    {
        this.name = name;
        this.password = password;
        this.gender = gender;
    }
}
