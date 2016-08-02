package LearningJava;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Vaith on 16/8/2.
 */
public class j012 {

    public static void main(String[] args)
    {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Data: " + ft.format(dNow));
    }
}
