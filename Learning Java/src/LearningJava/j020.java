package LearningJava;

/**
 * Created by Vaith on 16/8/2.
 */
public class j020 {
    public static void main(String[] args)
    {
        int j = 5;
        int i = 2;
        int k = max(j, i);
        System.out.println("The maximum between " + i + " and " + j + " is " + k);
    }

    public static int max(int num1, int num2)
    {
        int result;
        if (num1 > num2)
        {
            result = num1;
        }
        else
        {
            result = num2;
        }
        return result;
    }

}
