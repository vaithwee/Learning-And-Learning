package LearningJava;

import java.util.Date;

/**
 * Created by Vaith on 16/8/2.
 */
public class j014 {
    public static void main(String[] args)
    {
        Date date = new Date();
        System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);
    }
}
