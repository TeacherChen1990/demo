package demo.factory.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring容器测试代码
 */
public class SpringTest {

    public static void main(String[] args) {
        //获取Spring容器对象
        ApplicationContext app = new ClassPathXmlApplicationContext("");
        //从容器获取对象
        SpringTest bean = app.getBean("",SpringTest.class);
        //调用方法
        bean.run();
    }
    public void run(){
        System.out.println("run");
    }
}
