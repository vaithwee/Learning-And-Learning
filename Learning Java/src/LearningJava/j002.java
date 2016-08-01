package LearningJava;

/**
 * Created by Vaith on 16/8/1.
 */

class FreshJuice
{
    enum FreshJuiceSize {Small, Meduim, Large}
    FreshJuiceSize size;
}

public class j002 {
    public static void main(String []args)
    {
        FreshJuice jucie = new FreshJuice();
        jucie.size = FreshJuice.FreshJuiceSize.Meduim;
        System.out.println(jucie.size);
    }
}
