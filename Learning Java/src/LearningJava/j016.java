package LearningJava;

import java.util.Date;

/**
 * Created by Vaith on 16/8/2.
 */
public class j016 {
    public static void main(String[] args)
    {
        try {
            System.out.println(new Date());
            Thread.sleep(1000*3);
            System.out.println(new Date());
        } catch (Exception e)
        {
            System.out.println("Got an exception!");
        }
    }
}
