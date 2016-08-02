package LearningJava;

/**
 * Created by Vaith on 16/8/2.
 */
public class j021 {
    public static void main(String[] args)
    {
        printGrade(78.5);
    }
    public static void printGrade(double score)
    {
        if (score >= 90)
        {
            System.out.println("A");
        }
        else if (score >= 80)
        {
            System.out.println("B");
        }
        else if (score >= 70)
        {
            System.out.println("C");
        }
        else if (score >= 60)
        {
            System.out.println("D");
        }
        else
        {
            System.out.println("F");
        }

    }
}
