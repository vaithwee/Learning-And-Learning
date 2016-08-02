package LearningJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vaith on 16/8/2.
 */
public class J019 {
    public static void main(String[] args)
    {
        String line = "This order placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find())
        {
            System.out.println("Found Value:" + m.group(0));
            System.out.println("Found Value:" + m.group(1));
            System.out.println("Found Value:" + m.group(2));
        }else {
            System.out.print("No Match");
        }
    }
}
