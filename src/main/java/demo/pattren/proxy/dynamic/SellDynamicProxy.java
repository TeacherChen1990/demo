package demo.pattren.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//动态代理
public class SellDynamicProxy implements InvocationHandler {
    private Object object;

    public SellDynamicProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        //买掉房子
        Object result = method.invoke(object, args);
        after();
        return result;
    }
    //前置增强
    private void before(){
        System.out.println("新代理房屋销售");
        System.out.println("我先来做一下宣传");
        System.out.println("根据实际情况合房主沟通调整一下售价");
    }
    //后置增强
    private void after(){
        System.out.println("房子卖掉了，我提取佣金");
    }
}


