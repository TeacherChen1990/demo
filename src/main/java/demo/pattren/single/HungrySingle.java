package demo.pattren.single;

/**
 * 饿汉模式
 */
public class HungrySingle {

    /**
     * 饿汉模式，不管hungrySingle对象是否有使用到，都会先创建出来
     * 由于饿汉模式在对象使用之前就已经被创建，所以是不会存在线程安全问题
     */
    private static HungrySingle hungrySingle = new HungrySingle();
    /**
     * 私有化构造器，禁止外部创建
     */
    private HungrySingle(){
    }
    /**
     * 提供获取实例的方法
     */
    public static HungrySingle getInstance(){
        return hungrySingle;
    }
}
