package demo;

import java.util.concurrent.Callable;

/**
 * Runable与Callable比较
 */
public class RunableDemo {

    public static void main(String[] args) throws Exception {
        Callable<String> callable = () -> {
            Thread.sleep(5000);
            return "call执行完毕了";
        };
        System.out.println(Thread.currentThread());
        System.out.println("aaa");
        System.out.println(Thread.currentThread());
        System.out.println(callable.call());
        System.out.println(Thread.currentThread());
        System.out.println("哎哟");
    }
}
