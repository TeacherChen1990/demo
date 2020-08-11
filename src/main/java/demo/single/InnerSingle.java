package demo.single;

/**
 * 内部类的方式实现单例
 */
public class InnerSingle {

    private InnerSingle(){

    }

    private class Inner{
        public  final InnerSingle SINGLE = new InnerSingle();
    }
}
