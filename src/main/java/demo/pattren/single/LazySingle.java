package demo.pattren.single;

import java.io.ObjectStreamException;

/**
 * 懒汉模式
 */
public class LazySingle {
    /**
     * 懒汉模式，不会先创建对象，而是在调用的时候才会创建对象
     */
    //添加变量控制,防止反射破坏
    private static boolean isInstance = false;
    private volatile  static LazySingle lazySingle = null;
    private LazySingle() throws Exception {
        if(isInstance){
            throw new Exception("the Constructor has be used");
        }
        isInstance = true;
    }

    /**
     * 调用的时候创建对象并返回
     */
    public static LazySingle getInstance() throws Exception {
        //first check
        if(lazySingle == null){
            synchronized (LazySingle.class){
                //double check
                if(lazySingle == null){
                    lazySingle = new LazySingle();
                }
            }
        }
        return lazySingle;
    }

    private  class InnerClass{
        public void v(){
            System.out.println("Inner vo");
        }
    }

//    public static LazySingle getInstance(){
//        //可能会发生多线程安全问题而破坏单例
//        if(lazySingle == null){
//            lazySingle = new LazySingle();
//        }
//        return lazySingle;
//    }


}
