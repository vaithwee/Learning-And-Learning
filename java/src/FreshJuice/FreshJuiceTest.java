package FreshJuice;

/**
 * Created by Vaith on 16/7/28.
 */

class FreshJuice
{
    enum FreshJucieSize {SMALL, MEDUIM, LARGE}
    FreshJucieSize size;
}

public class FreshJuiceTest {
    public static void main(String []args)
    {
        //这个是单行注释
        /*
        * 这个是多行注释
        * */
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJucieSize.MEDUIM;
    }
}
