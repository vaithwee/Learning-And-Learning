package LearningJava;

import java.util.Date;

/**
 * Created by Vaith on 16/8/2.
 */
public class j013 {
    public static void main(String[] args)
    {
        Date date = new Date();
        String str = String.format("Current Data/Time: %tc", date);
        System.out.printf(str);
    }
}
