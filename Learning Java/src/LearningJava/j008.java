package LearningJava;

/**
 * Created by Vaith on 16/8/2.
 */

class InstanceCounter
{
    private  static int numInstances = 0;
    protected static int getCount()
    {
        return numInstances;
    }

    private static void addInstance()
    {
        numInstances++;
    }

    InstanceCounter()
    {
        InstanceCounter.addInstance();
    }


}

public class j008 {
    public static void main(String []args)
    {
        System.out.println("Start with " + InstanceCounter.getCount() + "instances");
        for (int i = 0; i < 500; ++i)
        {
            new InstanceCounter();
        }
        System.out.println("Created " + InstanceCounter.getCount() + " instances");
    }
}
