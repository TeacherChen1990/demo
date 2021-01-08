package demo.pattren.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(final Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        //买掉房子
        Object result = method.invoke(target, objects);
        after();
        return result;
    }

    //前置增强
    private void before() {
        System.out.println("新代理房屋销售");
        System.out.println("我先来做一下宣传");
        System.out.println("根据实际情况合房主沟通调整一下售价");
    }


    //后置增强
    private void after() {
        System.out.println("房子卖掉了，我提取佣金");
    }
}
