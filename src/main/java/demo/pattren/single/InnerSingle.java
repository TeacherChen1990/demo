package demo.pattren.single;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 内部类的方式实现单例
 */
public class InnerSingle implements Serializable {


    /**
     * 私有化构造器
     */
    private InnerSingle() {


    }
    /**
     * 私有内部类
     */
    private static class Inner{
        //Jingtai内部类持有外部类的对象
        public static final InnerSingle SINGLE = new InnerSingle();
    }
    /**
     * 返回静态内部类持有的对象
     */
    public static InnerSingle getInstance(){
        return Inner.SINGLE;
    }

    //在反序列化时，readResolve方法，则直接返回该方法指定的对象
    private  Object readResolve(){
        return getInstance();
    }
}
