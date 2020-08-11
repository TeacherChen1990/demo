package demo.factory.abstracts;

import demo.factory.Sender;

/**
 * 抽象工厂模式， 抽象层父类，提供创建产品的抽象方法，具体创建类型由工厂实现层管理
 */
public abstract class AbstractFactory {
    //抽象层提供创建对象的方法
    public abstract Sender getSender();
}
