package demo.pattren.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BreakInnerTest {
    public static void main(String[] args) throws Exception {
        Class<LazySingle> lazySingleClass = LazySingle.class;
//        //获取构造器
        Constructor<LazySingle> constructor = lazySingleClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        //创建对象
        LazySingle lazySingle = constructor.newInstance(null);
        //获取内部类的类对象
        Class<?> aClass = Class.forName("demo.pattren.single.LazySingle$InnerClass");
        Method[] methods = aClass.getMethods();
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        System.out.println(declaredConstructors);
        Constructor<?> declaredConstructor = declaredConstructors[0];
        declaredConstructor.setAccessible(true);
        //创建内部类需要传入一个外部类的对象
        Object o = declaredConstructor.newInstance(lazySingle);
        //成功绕过
        methods[0].invoke(o);
    }
}
