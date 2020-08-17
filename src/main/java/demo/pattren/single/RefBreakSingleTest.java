package demo.pattren.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射破坏单例
 */
public class RefBreakSingleTest {
    public static void main(String[] args) throws Exception {
//        //获取类对象
        Class<LazySingle> lazySingleClass = LazySingle.class;
//
//        //获取构造器
        Constructor<LazySingle> constructor = lazySingleClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        //创建对象
        LazySingle lazySingle = constructor.newInstance(null);
//        System.out.println(lazySingle);
//        Field isInstance = lazySingleClass.getDeclaredField("isInstance");
//        isInstance.setAccessible(true);
//        isInstance.set(null,false);
//        System.out.println(LazySingle.getInstance());
//        System.out.println(lazySingle == LazySingle.getInstance());

        Class<?> aClass = Class.forName("demo.pattren.single.LazySingle$InnerClass");
        Method[] methods = aClass.getMethods();
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        System.out.println(declaredConstructors);
        Constructor<?> declaredConstructor = declaredConstructors[0];
        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance(lazySingle);
        methods[0].invoke(o);
    }
}
