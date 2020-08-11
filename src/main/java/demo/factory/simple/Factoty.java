package demo.factory.simple;

import demo.factory.Sender;

public interface Factoty {

    /**
     * 获取sender对象
     */
    public Sender getSender(String senderCode);
}
