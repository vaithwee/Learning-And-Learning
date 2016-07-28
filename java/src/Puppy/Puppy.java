package Puppy;

/**
 * Created by Vaith on 16/7/28.
 */
public class Puppy {

    int puppyAge;
    public Puppy(String name)
    {
        System.out.println("Passed name is " + name);
    }

    public void setPuppyAge(int age)
    {
        puppyAge = age;
    }

    public int getPuppyAge()
    {
        System.out.println("Puppy's age is :" + puppyAge);
        return puppyAge;
    }



    public static void main(String []args)
    {
        Puppy puppy = new Puppy("tommy");
        puppy.setPuppyAge(2);
        puppy.getPuppyAge();
        System.out.println("Variable Value: " + puppy.puppyAge);
    }
}
