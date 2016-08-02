package LearningJava;

import java.util.*;
/**
 * Created by Vaith on 16/8/2.
 */
public class j017 {
    public static void main(String[] args)
    {
        try {
            long start = System.currentTimeMillis();
            System.out.println(new Date());
            Thread.sleep(5*60*10);
            System.out.println(new Date());
            long end = System.currentTimeMillis();
            long diff = end - start;
            System.out.println("Difference is " + diff);
        } catch (Exception e)
        {

        }
    }
}
